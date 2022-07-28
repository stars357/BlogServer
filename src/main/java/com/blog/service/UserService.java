package com.blog.service;

import com.blog.entity.User;
import com.blog.utils.ResponseResult;

public interface UserService {

    ResponseResult userLogin(User user);

    ResponseResult userLogout();
}
