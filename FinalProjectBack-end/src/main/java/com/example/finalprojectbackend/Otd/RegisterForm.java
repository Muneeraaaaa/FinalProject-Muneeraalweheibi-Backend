package com.example.finalprojectbackend.Otd;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class RegisterForm {

    private String username;
    private String password;
    private String firstname;
    private String lastename;
    private String role;
    private String email;


}
