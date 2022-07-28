package com.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.blog.mapper")
public class StarrySkyBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarrySkyBlogApplication.class, args);
    }

}
