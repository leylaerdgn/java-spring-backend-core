package com.leyla.spring_demo;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{
    private UserService _userService;
    public UserController(UserService userService){
          this._userService=userService;
     }
    @GetMapping("/users")
    ResponseEntity<List<User>> getUser(){
        return new ResponseEntity<>(_userService.getUser(), HttpStatus.OK);
    }
    @PostMapping("/users")
    ResponseEntity<List<User>> setUser(@RequestBody User user){
         _userService.setUser(user);
         return new ResponseEntity<>(_userService.getUser(),HttpStatus.CREATED);
    }
    @GetMapping("/users/{id}")
    ResponseEntity<User> oneUser(@PathVariable Long id){
        if((_userService.searchId(id) != null)){
            return new ResponseEntity<User>(_userService.searchId(id) ,HttpStatus.OK);

        }else{
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/users/{id}")
    ResponseEntity<Void> deleteId(@PathVariable Long id){
        if(_userService.deleteId(id)!= false){
              return ResponseEntity.noContent().build();
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/users/{id}")
    ResponseEntity<User> putId(@PathVariable Long id, @RequestBody User user){
      User updated = _userService.putUser(id, user);
        if (updated != null) {
            return new ResponseEntity<User>(updated, HttpStatus.OK);
        }else{
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        
    }

    }
