package com.blog.blogappapiutlimate.Service.Implementation;

import com.blog.blogappapiutlimate.Exception.ResourceNotFondException;
import com.blog.blogappapiutlimate.Model.User;
import com.blog.blogappapiutlimate.PayloadDTO.UserDto;
import com.blog.blogappapiutlimate.Repository.UserRepo;
import com.blog.blogappapiutlimate.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImple implements UserService {
    //we want object of service class
//Modify your UserServiceImple class to include constructor injection for UserRepo:

    private final UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImple(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDto createUser(UserDto userdto) {
        //to add user we need to convert userDto to user
        // so use "ModelMapper" or create a method for creating converting userdto to user."dtoToUser" and
        //to make tranfer data we also need user To userDto but this time it is public
        //this.userRepo is save to db. via repo
        User user = this.dtoToUser (userdto);
        User savedUser= this.userRepo .save (user) ;
        return this.userToDto (savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user= this.userRepo.findById (userId).orElseThrow (()-> new ResourceNotFondException ("User", "id",  userId));
        user.setName (userDto.getName ());
        user.setEmail (userDto.getEmail ());
        user.setPassword (userDto.getPassword ());
        user.setAbout (userDto.getAbout ());
        User updatedUser = this.userRepo.save (user);
        UserDto updatedUser1 = this.userToDto (updatedUser);
        return updatedUser1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById (userId).orElseThrow (()-> new ResourceNotFondException ("User", "id",  userId));
        return this.userToDto (user);
    }

    @Override
    public List<UserDto> getAllUses() {
        List<User> users=this.userRepo.findAll ();
        List<UserDto> usersDtos= users.stream ().map(user -> this.userToDto (user)).collect(Collectors.toList ());
        return usersDtos;
    }

    @Override
    public void deleteUse(Integer userId) {
      User user =  this.userRepo.findById (userId).orElseThrow (()->new ResourceNotFondException ("User","id",userId));
        this.userRepo.delete (user);

    }
//modelMapping explined

    private User dtoToUser(UserDto userdto ){
        User user = this.modelMapper.map(userdto,User.class);

//        User user = new User ();
//        user.setId (userdto.getId ());
//        user.setName (userdto.getName ());
//        user.setEmail (userdto.getEmail ());
//        user.setPassword (userdto.getPassword ());
//        user.setAbout (userdto.getAbout ());
        return  user;
    }
    public UserDto userToDto(User user){
        UserDto userDto = this.modelMapper.map (user,UserDto.class);
//        UserDto userDto = new UserDto ();
//        userDto.setId (user.getId ());
//        userDto.setName (user.getName ());
//        userDto.setEmail (user.getEmail ());
//        userDto.setAbout (user.getAbout ());
//        userDto.setPassword (user.getPassword ());
        return userDto;
    }
}
