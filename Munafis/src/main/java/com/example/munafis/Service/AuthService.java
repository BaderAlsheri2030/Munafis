package com.example.munafis.Service;



import com.example.munafis.API.ApiException;
import com.example.munafis.Model.User;
import com.example.munafis.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;


    public void register(User user){
        if (user.getRole().equalsIgnoreCase("company")){
            user.setRole("company");
        }else if (user.getRole().equalsIgnoreCase("provider")){
            user.setRole("provider");
        } else
        { throw new ApiException("Invalid role");}
        String hash = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hash);
        authRepository.save(user);
    }
    //only admin
    public List<User> getAllUsers(){
        return authRepository.findAll();
    }

    public void updateUser(User user,Integer auth){
        User user1 =authRepository.findUserById(auth);
        user.setId(auth);

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setUsername(user.getUsername());
        user.setRole(user1.getRole());
        authRepository.save(user);
    }

    public void deleteUser(Integer id){
        User user = authRepository.findUserById(id);
        if(user==null){
            throw new ApiException("User Not Found");
        }
        authRepository.delete(user);
    }

}