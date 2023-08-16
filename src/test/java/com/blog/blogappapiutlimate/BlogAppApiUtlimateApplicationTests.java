package com.blog.blogappapiutlimate;

import com.blog.blogappapiutlimate.Repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogAppApiUtlimateApplicationTests {
    @Autowired
    private UserRepo userRepo;

    @Test
    void contextLoads() {
    }
    @Test
    public void repoTest(){
    String className = this.userRepo.getClass ().getName ();
    String packName =this.userRepo.getClass ().getPackageName ();
        System.out.println (className+"      "+packName);
    }

}
