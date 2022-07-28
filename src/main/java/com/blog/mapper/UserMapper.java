package com.blog.mapper;

import com.blog.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User getUserByName(String name);

}
