package com.blog.blogappapiutlimate.Model;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.awt.*;


public class Post extends Base {
    private String title;
    private String content;
    private String image;
    private Category category;
    private User user;
=======
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="posts")
@Data
@NoArgsConstructor

public class Post extends Base {
    @Column(name="post_title",length = 100,nullable = false)
    private String title;
    @Column(length = 10000)
    private String content;
    private String imageName;
    private Date addedDate;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @ManyToOne
    private User user;

>>>>>>> 3f19c96 (Post Api are created.implemented pagination in getAllPost(). by using PageRequest)
}
