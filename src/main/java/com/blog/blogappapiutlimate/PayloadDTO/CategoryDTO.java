package com.blog.blogappapiutlimate.PayloadDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
=======
import lombok.*;
>>>>>>> 3f19c96 (Post Api are created.implemented pagination in getAllPost(). by using PageRequest)

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
<<<<<<< HEAD
=======

>>>>>>> 3f19c96 (Post Api are created.implemented pagination in getAllPost(). by using PageRequest)
public class CategoryDTO {
    private Integer id;
    @NotBlank
    @Size(min=4,message = "Min size of category tittle is 4")
    private String title;
    @NotBlank
    @Size(min=10,message = "Min size of category tittle is 10")
    private  String categoryDescription;
}
