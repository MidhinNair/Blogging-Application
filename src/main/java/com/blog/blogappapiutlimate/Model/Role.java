package com.blog.blogappapiutlimate.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity@Table
public class Role extends Base {
    private String name;
}
