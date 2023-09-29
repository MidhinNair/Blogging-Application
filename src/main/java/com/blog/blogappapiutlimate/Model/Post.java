package com.blog.blogappapiutlimate.Model;


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


}
