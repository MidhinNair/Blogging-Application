package com.blog.blogappapiutlimate.Service;

import com.blog.blogappapiutlimate.PayloadDTO.CategoryDTO;

import java.util.List;


public interface CategoryService {
    //inside interface no need to give public it bydefault become public
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(CategoryDTO categoryDTO,Integer id);
    void deleteCategory(Integer id);
    CategoryDTO getCategoryById(Integer id);

    List<CategoryDTO> getAllCategory() ;



}
