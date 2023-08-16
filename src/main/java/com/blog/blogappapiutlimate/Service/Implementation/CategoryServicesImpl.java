package com.blog.blogappapiutlimate.Service.Implementation;

import com.blog.blogappapiutlimate.Exception.ResourceNotFondException;
import com.blog.blogappapiutlimate.Model.Category;
import com.blog.blogappapiutlimate.PayloadDTO.CategoryDTO;
import com.blog.blogappapiutlimate.Repository.CategoryRepo;
import com.blog.blogappapiutlimate.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServicesImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    private final ModelMapper modelMapper;
    @Autowired
    public CategoryServicesImpl(CategoryRepo categoryRepo, ModelMapper modelMapper) {
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category=this.DtoToCategory (categoryDTO);
        Category savedCategory=this.categoryRepo.save (category);
        return this.categoryToDto (savedCategory);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer id) {
        Category category = this.categoryRepo.findById (id).orElseThrow (()-> new ResourceNotFondException ("Category","id",id));
        category.setTitle (categoryDTO.getTitle ());
        category.setCategoryDescription (categoryDTO.getCategoryDescription ());
        Category updatedcategory=this.categoryRepo.save (category);
        return this.categoryToDto (updatedcategory);
    }

    @Override
    public void deleteCategory(Integer id) {
        Category category = this.categoryRepo.findById (id).orElseThrow (()-> new ResourceNotFondException ("Category","id",id));
        this.categoryRepo.delete (category);

    }

    @Override
    public CategoryDTO getCategoryById(Integer id) {
        Category category = this.categoryRepo.findById (id).orElseThrow (()-> new ResourceNotFondException ("Category","id",id));
        return  this.categoryToDto (category);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categoryList = this.categoryRepo.findAll ();
        List<CategoryDTO> categoryDTOList =categoryList.stream ().map (category -> this.categoryToDto (category)).collect(Collectors.toList ());
        return  categoryDTOList;

    }
    public CategoryDTO categoryToDto(Category category){
        CategoryDTO categoryDTO = this.modelMapper.map (category,CategoryDTO.class);
        return categoryDTO;

    }
    public Category DtoToCategory(CategoryDTO categoryDTO){
        Category category = this.modelMapper.map (categoryDTO,Category.class);
        return category;
    }
}
