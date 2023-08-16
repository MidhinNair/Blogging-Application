package com.blog.blogappapiutlimate.PayloadDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDto {
    private Integer id;
    private String title;
    private String content;
    private  String imageName;
    private Date addeddate;
    private CategoryDTO categoryDto;
    private UserDto userDto;


}
