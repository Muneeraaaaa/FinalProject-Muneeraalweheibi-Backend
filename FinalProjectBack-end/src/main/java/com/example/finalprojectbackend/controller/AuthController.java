package com.example.finalprojectbackend.controller;

import com.example.finalprojectbackend.Otd.ApiResponce;
import com.example.finalprojectbackend.Otd.RegisterForm;
import com.example.finalprojectbackend.model.Users;
import com.example.finalprojectbackend.srvice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    //CRUD(create,read,update,delete) - the user cant have get all users


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterForm registerForm){

        String hashedpassword=new BCryptPasswordEncoder().encode(registerForm.getPassword());
        registerForm.setPassword(hashedpassword);
            //public User(String id, String fisrtName, String lasteName, String role, String password, String username, String email) {

            Users user=new Users(null,registerForm.getFirstname(),registerForm.getLastename(),registerForm.getRole(),registerForm.getPassword(),registerForm.getUsername(),registerForm.getEmail());
            Users newuser=userService.adduser(user);

            return ResponseEntity.status(201).body(new ApiResponce("New user is register ",201));
            }
            @DeleteMapping("/delete")
    public ResponseEntity deleteuser(@AuthenticationPrincipal Users users){

        userService.Delteuser(users);
                return ResponseEntity.status(201).body(new ApiResponce("The user is deleted  ",201));

            }

            @PostMapping("/update")
    public ResponseEntity updateUser(@AuthenticationPrincipal Users users,@RequestBody Users userss){

        userService.updateUser(users,userss);
                return ResponseEntity.status(201).body(new ApiResponce("The User is updated ",201));

            }
//    @PostMapping ("/login")
//    public ResponseEntity login (){
//        return ResponseEntity.status(200).body(new ApiResponce("Welcome Back !",200));
//    }



    }


