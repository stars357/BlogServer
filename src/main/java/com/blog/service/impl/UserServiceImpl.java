package com.blog.service.impl;

import com.blog.entity.LoginUser;
import com.blog.entity.User;
import com.blog.service.UserService;
import com.blog.utils.JwtUtils;
import com.blog.utils.LoginUserstorage;
import com.blog.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private LoginUserstorage loginUserstorage;

    @Override
    public ResponseResult userLogin(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getName(), user.getPwd());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
//        throw new RuntimeException("登陆失败");
//        System.out.println("3");
        //如果认证没通过，给出对应的提示
        if(Objects.isNull(authenticate)){
//            System.out.println("2");
            throw new RuntimeException("登陆失败");
        }

        //如果认证通过了，使用userid生成一个jwt
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String id = loginUser.getUser().getId().toString();
//        System.out.println(id);
        loginUserstorage.addUserInfo(id ,loginUser.getUser());

        JwtUtils jwtUtils = new JwtUtils();
        HashMap<String, String> userMap = new HashMap();
        userMap.put("uid", id);
        Date exp = new Date(System.currentTimeMillis()+60*60*12*1000 + 60*60*8*1000);//60*60*8*1000是因为Java获取的时间慢8小时,*1000因为System.currentTimeMillis()获取的是以毫秒为单位
        String token = jwtUtils.createJwt(exp ,userMap);

        return new ResponseResult(200, "登录成功", token);


    }

    @Override
    public ResponseResult userLogout() {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authenticationToken.getPrincipal();
        String uid = loginUser.getUser().getId().toString();
        boolean loginState = loginUserstorage.deleteUserInfo(uid);
        if(loginState){
            return new ResponseResult(200, "退出成功");
        }else {
            return new ResponseResult(401, "退出失败");
        }
    }


}
