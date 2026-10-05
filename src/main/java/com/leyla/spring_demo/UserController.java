package com.leyla.spring_demo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{
    private List<User> users = new ArrayList();

    @GetMapping("/users")
    public List<User> user(){
        return users;
    }
    @PostMapping("/users")
    public List<User> user(@RequestBody User user){
        users.add(user);
        return users;
    }
}