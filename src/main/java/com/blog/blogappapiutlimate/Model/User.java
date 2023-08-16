package com.blog.blogappapiutlimate.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
//for table name change
@Table(name="users")
public class User extends Base {
    @Column(name="user_name",nullable = false,length = 50)

    private String name;
    @Column(nullable = false,length = 50)

    private String email;
    private String password;
    private String about;
}
