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

    public User searchId(Long id){
    for(User u: users){
     if(u.getId().equals(id)){
        return u;
     }
    }
        return null;
    }

    public boolean deleteId(Long id){
     for(User u: users){
          if(u.getId().equals(id)){
            return users.remove(u);
          }
             }
             return false;

    }

    public User putUser(Long id, User updatedUser){
        for(User u: users){
            if(u.getId().equals(id)){
               u.setName(updatedUser.getName());
               return u;
            }
        }
        return null;
    }
    }
    

