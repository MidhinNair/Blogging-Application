package com.blog.blogappapiutlimate.PayloadDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UserDto {
    private Integer id;
    @NotBlank
    @Size(min=4,message="User name must be min of 4 character")
    private String name;
    @Email (message = "Email is not valid")
    @NotBlank
    private String email;
    @NotBlank
    @Size(min=3,max=10, message = "Password must be min of 3 and maximum of 10")

    private  String password;
    @NotBlank
    private String about;
}
