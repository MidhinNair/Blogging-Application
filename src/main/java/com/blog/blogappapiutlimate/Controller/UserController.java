package com.blog.blogappapiutlimate.Controller;

import com.blog.blogappapiutlimate.PayloadDTO.ApiResponse;
import com.blog.blogappapiutlimate.PayloadDTO.UserDto;
import com.blog.blogappapiutlimate.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    //Post - create user
    //Put - update user
    //Delete - delete userc
    //Get - get user

   // Update your UserController to inject the UserService using constructor injection:
    private final UserService userService;
    //Post - create user
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }




    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createdUserDto = this.userService.createUser (userDto);
        return new ResponseEntity<> (createdUserDto, HttpStatus.CREATED);
    }



//    @GetMapping@Id({"/userId"})
//    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto){
//
//    }
//Get - get user
    @GetMapping("/")
    public  ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok (this.userService.getAllUses ());
    }

    //Get - get user
    @GetMapping("/{id}")
    public  ResponseEntity<UserDto> getUserById( @PathVariable Integer id){
        return ResponseEntity.ok (this.userService.getUserById (id));
    }
    //Put - update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser( @Validated @RequestBody UserDto userDto,@PathVariable Integer userId ){
        UserDto updateUser =this.userService.updateUser (userDto,userId);
        return ResponseEntity.ok (updateUser);
    }
    //Delete - delete userc

    @DeleteMapping("/{uId}")
    public  ResponseEntity<ApiResponse> deteteUser(  @PathVariable Integer uId){
        this.userService.deleteUse (uId);
       return new ResponseEntity(new ApiResponse ("User deleted successfully",true),HttpStatus.OK);
    }

}
