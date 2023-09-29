package com.blog.blogappapiutlimate.PayloadDTO;

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

public class CategoryDTO {
    private Integer id;
    @NotBlank
    @Size(min=4,message = "Min size of category tittle is 4")
    private String title;
    @NotBlank
    @Size(min=10,message = "Min size of category tittle is 10")
    private  String categoryDescription;
}
