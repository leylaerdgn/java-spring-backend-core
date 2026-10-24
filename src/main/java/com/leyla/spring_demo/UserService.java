package com.leyla.spring_demo;
import java.util.ArrayList;
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
 //Bu metot veritabanındaki kullanıcıları getirip postmane göndermek için kullanılıyor.
 // Bizde veritabanındaki User nesnelerini doğrudan dışarıya göndermek yerine userResponseDTO kullanacaz.
    public List<UserResponseDTO> getUser(){
        List<User> users= _userRepository.findAll();
        List<UserResponseDTO> dtoList=new ArrayList<>();
        for(User u: users){
           dtoList.add(new UserResponseDTO(u.getId(), u.getName()));
        }
        return dtoList;
    }

    //Postman'den gönderdiğimiz kullanıcı bilgilerini alıp veritabanına kaydeder 
    // ve kaydedilen kullanıcının ID'sini ve adını DTO aracılığıyla Postman'e geri gönderir.
    //Yeni kullanıcı eklemek için yazılmıştır
    public UserResponseDTO createUser(UserRequestDTO requestDTO) {
        User user = new User(); //Postmanden yeni bir kullanıcı geldiği için onu veritabanına kaydetmek için User nesnesi oluşturuyoruz.
        user.setName(requestDTO.getName());
        User savedUser = _userRepository.save(user);
        return new UserResponseDTO(savedUser.getId(), savedUser.getName()); //ile kaydedilen kullanıcının ID'sini ve adını Postman'e döndürmek üzere DTO oluşturuyoruz.
       }

    public UserResponseDTO searchId(Long id){
        User user= _userRepository.findById(id).orElse(null);
        if(user != null){
            return new UserResponseDTO(user.getId(), user.getName()); //buradaki new elimdeki user nesnensini dto'ya dönüştürmeme yarıyor.
        }else{
            return null;
        }
    }

    public boolean deleteId(Long id){
        if(_userRepository.existsById(id)){
            _userRepository.deleteById(id);
            return true;
        }else{
            return false;
        }

    }
//Postman'den gelen yeni bilgileri alıp veritabanındaki mevcut kullanıcının üzerine yazar ve güncellenmiş halini Postman'e geri döner.
    public UserResponseDTO putUser(Long id, UserRequestDTO userDto){
        User user= _userRepository.findById(id).orElse(null);
        if(user!=null){
             user.setName(userDto.getName()); //Yeni bilgi nereden geliyor? (KAYNAK) -> Postman'den gelen DTO'dan! Yani userDto.getName()
             User saveUser=_userRepository.save(user);  
             return new UserResponseDTO(saveUser.getId(), saveUser.getName());                                                            //Ben bu yeni bilgiyi nereye yapıştırmak istiyorum? (HEDEF) -> Veritabanındaki user nesnesinin içine! Yani user.setName(...)
        }          
        return null;
    }
}
