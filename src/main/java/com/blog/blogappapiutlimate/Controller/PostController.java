package com.blog.blogappapiutlimate.Controller;

import com.blog.blogappapiutlimate.PayloadDTO.ApiResponse;
import com.blog.blogappapiutlimate.PayloadDTO.PostDto;
import com.blog.blogappapiutlimate.PayloadDTO.PostResponse;
import com.blog.blogappapiutlimate.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {
    private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }



    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost( @RequestBody PostDto postDto,
                                               @PathVariable Integer userId,
                                               @PathVariable  Integer categoryId){

        PostDto createdPost=this.postService.createPost (postDto, userId, categoryId);
        return new ResponseEntity<PostDto> (createdPost, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{postId}")
    public  ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){

        PostDto updatedPost = this.postService.updatePost (postDto,postId);
        return  new ResponseEntity<PostDto> (updatedPost,HttpStatus.OK);
    }

//    If you intend to create a new post or perform other operations that require a request body,
//    you should use a different HTTP method like @PostMapping, @PutMapping, or @PatchMapping as appropriate,
//    and use the @RequestBody annotation to capture the request data.
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
    List<PostDto>postsByUser = this.postService.getPostByUser (userId);
    return  new ResponseEntity<List<PostDto>> (postsByUser,HttpStatus.OK);
    }
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
        List<PostDto>postsByCategory = this.postService.getPostByCategory (categoryId);
        return  new ResponseEntity<List<PostDto>> (postsByCategory,HttpStatus.OK);
    }
    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
        PostDto postById= this.postService.getPostById (postId);

        return new ResponseEntity<> (postById,HttpStatus.OK);
    }
    @GetMapping("/posts/title/{title}")
    public ResponseEntity<List<PostDto>> getAllPostByTitle(@PathVariable String title){
        List<PostDto> allPosts = this.postService.searchPost (title);
        return new ResponseEntity<List<PostDto>> (allPosts,HttpStatus.OK);
    }
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value ="pageNumber",defaultValue="0",required =false) Integer pageNumber,
            @RequestParam(value ="pageSize",defaultValue="5",required =false) Integer pageSize
              ){
        PostResponse allPosts = this.postService.getAllPost (pageNumber,pageSize);
        return new ResponseEntity<PostResponse> (allPosts,HttpStatus.OK);
    }
    @DeleteMapping("/post/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
        this.postService.deletePost (postId);
        return  new ResponseEntity<> (new ApiResponse ("post deleted Successfully",true),HttpStatus.OK);
    }
}
