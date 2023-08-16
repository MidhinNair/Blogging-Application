package com.blog.blogappapiutlimate.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity@Table(name = "categories")
public class Category extends Base{

    @Column(nullable=false,length = 100)
    private String title;
    @Column(name="description",nullable=false)
    private  String categoryDescription;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
    private List<Post> posts = new ArrayList<> ();
}
