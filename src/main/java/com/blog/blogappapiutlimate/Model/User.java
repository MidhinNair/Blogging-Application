package com.blog.blogappapiutlimate.Model;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

=======
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

>>>>>>> 3f19c96 (Post Api are created.implemented pagination in getAllPost(). by using PageRequest)
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
<<<<<<< HEAD
=======
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
    private List<Post> posts = new ArrayList<> ();
>>>>>>> 3f19c96 (Post Api are created.implemented pagination in getAllPost(). by using PageRequest)
}
