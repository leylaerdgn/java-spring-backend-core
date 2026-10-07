package com.leyla.spring_demo;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private List<User> users = new ArrayList();

    public List<User> getUser(){
        return users;
    }
    
    public void setUser(User user){
        users.add(user);
    }
}
