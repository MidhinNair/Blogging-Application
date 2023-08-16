package com.blog.blogappapiutlimate.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
@MappedSuperclass
@Data
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //for auto increment
    private Integer id;
}
