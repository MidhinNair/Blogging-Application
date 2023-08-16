package com.blog.blogappapiutlimate.Service;

import com.blog.blogappapiutlimate.PayloadDTO.PostDto;
import com.blog.blogappapiutlimate.PayloadDTO.PostResponse;

import java.util.List;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto, Integer userId,Integer categoryId);



    //update
    PostDto updatePost(PostDto postDto,Integer postId);
    //delete
    void deletePost(Integer PostId);
    //get all post with pagination


    //get all post
    PostResponse getAllPost(Integer pageNumber , Integer pageSize);
    //get single post
    PostDto getPostById(Integer PostId);
    List<PostDto> getPostByCategory(Integer CategoryId);
    //get all posts by user
    List<PostDto> getPostByUser(Integer userId);
    //search post by key word
    List<PostDto> searchPost(String Keyword);


}
