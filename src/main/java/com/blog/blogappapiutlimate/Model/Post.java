package com.blog.blogappapiutlimate.Model;

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
}
