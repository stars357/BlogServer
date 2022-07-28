package com.blog.controller;

import com.blog.entity.User;
import com.blog.service.impl.UserServiceImpl;
import com.blog.utils.LoginUserstorage;
import com.blog.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private LoginUserstorage loginUserstorage;

    @PostMapping("/login")
    public ResponseResult userLogin(@RequestBody User user){
        return this.userService.userLogin(user);
    }

    @GetMapping("/demo")
    public ResponseResult demo(){
        return new ResponseResult(200, loginUserstorage.findUserInfo("1"));
    }

    @GetMapping("/demoa")
    public ResponseResult demoa(){
        return new ResponseResult(200, "tg");
    }

    @PostMapping("/logout")
    public ResponseResult userLogout(){
        return userService.userLogout();
    }
}
