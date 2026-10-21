package com.leyla.spring_demo;
import java.util.List;

import org.springframework.stereotype.Service;

import com.leyla.spring_demo.DTO.UserRequestDTO;
import com.leyla.spring_demo.DTO.UserResponseDTO;

@Service
public class UserService {
    private UserRepository _userRepository;

    public UserService(UserRepository userRepository){
        this._userRepository = userRepository;
    }

    public List<User> getUser(){
        return _userRepository.findAll();
    }

    public UserResponseDTO setUser(UserRequestDTO requestDTO) {
        User user = new User();
        user.setName(requestDTO.getName());
        User savedUser = _userRepository.save(user);
        return new UserResponseDTO(savedUser.getId(), savedUser.getName()); 
       }

    public User searchId(Long id){
        return _userRepository.findById(id).orElse(null);
    }

    public boolean deleteId(Long id){
        if(_userRepository.existsById(id)){
            _userRepository.deleteById(id);
            return true;
        }else{
            return false;
        }

    }

    public User putUser(Long id, User updatedUser){
        User user= _userRepository.findById(id).orElse(null);
        if(user!=null){
            user.setName(updatedUser.getName());
            return _userRepository.save(user);
        }          
        return null;
    }
}
