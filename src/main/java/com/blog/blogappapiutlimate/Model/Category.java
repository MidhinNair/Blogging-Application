package com.blog.blogappapiutlimate.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity@Table(name = "categories")
public class Category extends Base{

    @Column(nullable=false,length = 100)
    private String title;
    @Column(name="description",nullable=false)
    private  String categoryDescription;
}
