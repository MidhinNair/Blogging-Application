package com.blog.blogappapiutlimate.Service.Implementation;

import com.blog.blogappapiutlimate.Exception.ResourceNotFondException;
import com.blog.blogappapiutlimate.Model.Category;
import com.blog.blogappapiutlimate.Model.Post;
import com.blog.blogappapiutlimate.Model.User;
import com.blog.blogappapiutlimate.PayloadDTO.CategoryDTO;
import com.blog.blogappapiutlimate.PayloadDTO.PostDto;
import com.blog.blogappapiutlimate.PayloadDTO.PostResponse;
import com.blog.blogappapiutlimate.PayloadDTO.UserDto;
import com.blog.blogappapiutlimate.Repository.CategoryRepo;
import com.blog.blogappapiutlimate.Repository.PostRepo;
import com.blog.blogappapiutlimate.Repository.UserRepo;
import com.blog.blogappapiutlimate.Service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    private final ModelMapper modelMapper;
    private final UserRepo userRepo;
    private final CategoryRepo categoryRepo;
    @Autowired
    public PostServiceImpl(PostRepo postRepo, ModelMapper modelMapper, UserRepo userRepo, CategoryRepo categoryRepo) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public PostDto createPost(PostDto postDto , Integer userId,Integer categoryId) {
        User user = this.userRepo.findById (userId)
                .orElseThrow (()-> new ResourceNotFondException ("User","userId",userId));
        Category category = this.categoryRepo.findById (categoryId)
                .orElseThrow (()-> new ResourceNotFondException ("category","categoryId",categoryId));

        Post post= this.modelMapper.map(postDto, Post.class);
        post.setImageName ("Default.png");
        post.setAddedDate (new Date ());
        post.setUser (user);
        post.setCategory (category);
        Post createdPost=this.postRepo.save (post);
        PostDto createdPostDto = modelMapper.map(createdPost, PostDto.class);
        createdPostDto.setCategoryDto (modelMapper.map (category, CategoryDTO.class));
        createdPostDto.setUserDto (modelMapper.map(user, UserDto.class));
        return createdPostDto;
    }

    @Override
    public PostDto updatePost(PostDto postDto,Integer postId) {
        Post post= this.postRepo.findById (postId).orElseThrow (()-> new ResourceNotFondException ("Post","PostId",postId));
        post.setTitle (postDto.getTitle ());
        post.setContent (postDto.getContent ());
        post.setImageName (postDto.getImageName ());
        PostDto postDtoUpdated = this.modelMapper.map(post, PostDto.class);
        postDtoUpdated.setCategoryDto (modelMapper.map (post.getCategory (), CategoryDTO.class));
        postDtoUpdated.setUserDto (modelMapper.map(post.getUser (), UserDto.class));
        return postDtoUpdated;
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById (postId).orElseThrow (()-> new ResourceNotFondException ("Post","postId",postId));
        postRepo.deleteById (postId);
    }

    @Override
    public PostResponse getAllPost(Integer pageNo, Integer pageSize) {

        PageRequest p =  PageRequest.of (pageNo, pageSize);
        Page<Post> postPage = this.postRepo.findAll ( p);
        List<Post> allPost = postPage.getContent ();
       //List<Post> allPostWithoutPageable = this.postRepo.findAll ();
        List<PostDto>allPostDto= allPost.stream ()
                .map (post->mapPostToPostDto (post))
                .collect(Collectors.toList());
        PostResponse postResponse = new PostResponse ();
        postResponse.setContent (allPostDto);
        postResponse.setPageNumber (postPage.getNumber ());
        postResponse.setPageSize (postPage.getSize ());
        postResponse.setTotalElement (postPage.getTotalElements ());
        postResponse.setTotalPages (postPage.getTotalPages ());
        postResponse.setLastPage (postPage.isLast ());
        return postResponse;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post postById = this.postRepo.findById (postId)
                .orElseThrow (()->new ResourceNotFondException ("Post","postId",postId));
        PostDto postDtoById = mapPostToPostDto(postById);
        return postDtoById;
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById (categoryId )
                .orElseThrow (()->new ResourceNotFondException ("category","categoryId",categoryId));
        List<Post> posts =this.postRepo.findByCategory(category);
        List<PostDto>postsByCategory = posts.stream ()
              .map(post -> mapPostToPostDto (post))
              .collect (Collectors.toList ())   ;
      return  postsByCategory;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        User user = this.userRepo.findById (userId )
                .orElseThrow (()->new ResourceNotFondException ("user","userId",userId));

        List<Post> posts =this.postRepo.findByUser (user);
        List<PostDto>postsByUser = posts.stream ()
                .map(post -> mapPostToPostDto (post))
                .collect (Collectors.toList ())   ;

        return  postsByUser;
    }
    private PostDto mapPostToPostDto(Post post) {
        PostDto postDto = this.modelMapper.map(post, PostDto.class);
        postDto.setCategoryDto (modelMapper.map (post.getCategory (), CategoryDTO.class));
        postDto.setUserDto (modelMapper.map(post.getUser (), UserDto.class));
        return postDto;
    }
//    private PostDto mapPostToPostDtoByUser(Post post) {
//        PostDto postDto = this.modelMapper.map(post, PostDto.class);
//
//        postDto.setUserDto (modelMapper.map(post.getUser (), UserDto.class));
//        return postDto;
//    }
//    private PostDto mapPostToPostDtoByCategory(Post post) {
//        PostDto postDto = this.modelMapper.map(post, PostDto.class);
//        postDto.setCategoryDto (modelMapper.map (post.getCategory (), CategoryDTO.class));
//        return postDto;
//    }
    @Override
    public List<PostDto> searchPost(String keyword) {

       List<Post> postsByTitle = this.postRepo.findByTitleContaining(keyword);

        List<PostDto>postsDtoByTitle = postsByTitle.stream ()
                .map(post -> mapPostToPostDto (post))
                .collect (Collectors.toList ())   ;
        return postsDtoByTitle;
    }
}
