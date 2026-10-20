package com.leyla.spring_demo;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class UserService {
  private UserRepository _userRepository;

  public UserService(UserRepository userRepository){
    this._userRepository=userRepository;
  }
   public List<User> getUser(){
    return _userRepository.findAll();
   }

  public User setUser(User user) {
    return _userRepository.save(user); // Hem parametre verildi hem de User döndürüldü
}

    public User searchId(Long id){
        return _userRepository.findById(id).orElse(null);
    }

    public boolean deleteId(Long id){
       if(_userRepository.existsById(id)){
        _userRepository.deleteById(id);
        return true;
       }
       return false;
    }

     public User putUser(Long id, User updatedUser){
        User user = _userRepository.findById(id).orElse(null);
        if(user != null){
            user.setName(updatedUser.getName());
            return _userRepository.save(user);
        }
        return null;
    }
}
    

