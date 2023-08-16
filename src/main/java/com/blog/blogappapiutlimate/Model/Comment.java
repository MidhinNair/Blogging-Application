package com.blog.blogappapiutlimate.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.awt.*;

public class Comment extends Base{
    private String content;
    private Post post;
    private User user;

}
