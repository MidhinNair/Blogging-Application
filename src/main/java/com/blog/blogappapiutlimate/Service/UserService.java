package com.blog.blogappapiutlimate.Service;

import com.blog.blogappapiutlimate.PayloadDTO.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer Id);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUses();

    void deleteUse(Integer useId);
}