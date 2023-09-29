package com.blog.blogappapiutlimate.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
    private List<Post> posts = new ArrayList<> ();

}
