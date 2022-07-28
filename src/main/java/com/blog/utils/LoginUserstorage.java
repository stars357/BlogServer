package com.blog.utils;

import com.blog.entity.User;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LoginUserstorage {

    private Map<String, User> userMap = new HashMap<String, User>();

    public void addUserInfo(String id, User user){
//        System.out.println(user);
        this.userMap.put(id, user);
    }

    public User findUserInfo(String id){
        return this.userMap.get(id);
    }

    public boolean LoginState(String id){
        return this.userMap.containsKey(id);
    }

    public boolean deleteUserInfo(String id){
        try {
            if(userMap.containsKey(id)){
                this.userMap.remove(id);
                return true;
            }else {
                return true;
            }
        }catch (Exception e){
            return false;
        }
    }

}
