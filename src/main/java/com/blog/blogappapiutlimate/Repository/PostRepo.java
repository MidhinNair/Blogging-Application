package com.blog.blogappapiutlimate.Repository;

import com.blog.blogappapiutlimate.Model.Category;
import com.blog.blogappapiutlimate.Model.Post;
import com.blog.blogappapiutlimate.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    List<Post> findByTitleContaining(String title);

}
