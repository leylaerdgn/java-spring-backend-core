package com.leyla.spring_demo;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{
    private UserService _userService;
    public UserController(UserService userService){
          this._userService=userService;
     }
    @GetMapping("/users")
    public List<User> getUser(){
        return _userService.getUser();
    }
    @PostMapping("/users")
    public void setUser(@RequestBody User user){
         _userService.setUser(user);
    }
}