package com.blog.filter;

import com.blog.entity.LoginUser;
import com.blog.entity.User;
import com.blog.utils.JwtUtils;
import com.blog.utils.LoginUserstorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class AuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private LoginUserstorage loginUserstorage;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //从请求头中获取token
        String token = request.getHeader("token");
//        System.out.println(token);
        //如果token没有值则放行
        if (!StringUtils.hasText(token)){
            filterChain.doFilter(request, response);
            //防止响应也经过此过滤器，return一下
            return;
        }

        //解析token
        JwtUtils jwtUtils = new JwtUtils();
        Map<String, String> userMap = jwtUtils.getPayLoadALSOExcludeExpAndIat(token);
//        System.out.println(userMap);
        if (Objects.isNull(userMap)){
            System.out.println(123);
            filterChain.doFilter(request, response);
            //防止响应也经过此过滤器，return一下
            return;
        }
        String id = userMap.get("uid");
        User user = loginUserstorage.findUserInfo(id);
        if (Objects.isNull(user)){
            filterChain.doFilter(request, response);
            //防止响应也经过此过滤器，return一下
            return;
        }
        //存入SecurityContextHolder
//            System.out.println("tg");
            LoginUser loginUser = new LoginUser(user);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, null);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            filterChain.doFilter(request, response);

    }
}
