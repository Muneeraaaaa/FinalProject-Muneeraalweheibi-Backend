package com.example.finalprojectbackend.srvice;

import com.example.finalprojectbackend.Repositry.UserRepositry;
import com.example.finalprojectbackend.model.Places;
import com.example.finalprojectbackend.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {


    public final UserRepositry userRepositry;

    public Users adduser(Users user){

        return userRepositry.save(user);
    }
    public void Delteuser(Users user){

        userRepositry.delete(user);
    }
    //()()()()()()()()()()
    public void updateUser(Users olduser,Users newusers){

        Users newUser=userRepositry.findUsersById(olduser.getId());
        newUser.setEmail(newusers.getEmail());
        newUser.setPassword(newusers.getPassword());
        newUser.setRole(newusers.getRole());
        newUser.setUsername(newusers.getUsername());
        newUser.setFisrtName(newusers.getFisrtName());
        newUser.setLasteName(newusers.getLasteName());
        userRepositry.save(newUser);
    }


}
