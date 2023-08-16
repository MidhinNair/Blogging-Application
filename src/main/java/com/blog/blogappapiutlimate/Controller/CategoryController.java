package com.blog.blogappapiutlimate.Controller;

import com.blog.blogappapiutlimate.PayloadDTO.ApiResponse;
import com.blog.blogappapiutlimate.PayloadDTO.CategoryDTO;
import com.blog.blogappapiutlimate.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        CategoryDTO createdCategoryDto = this.categoryService.createCategory (categoryDTO);
        return  new ResponseEntity<CategoryDTO> (createdCategoryDto, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid@RequestBody CategoryDTO categoryDTO,@PathVariable Integer id){
        CategoryDTO updatedCategoryDTO = this.categoryService.updateCategory (categoryDTO,id);
        return  new ResponseEntity<CategoryDTO> (updatedCategoryDTO, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse>deleteCategory(@PathVariable Integer id){
        this.categoryService.deleteCategory (id);
        return  new ResponseEntity<ApiResponse> (new  ApiResponse("Category deleted successfully",true),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById (@PathVariable Integer id){
        return new ResponseEntity<CategoryDTO> ((this.categoryService.getCategoryById (id)),HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllCategory(){
       List<CategoryDTO> allCategoryDto=this.categoryService.getAllCategory ();
       return  ResponseEntity.ok (allCategoryDto);
    }
}
