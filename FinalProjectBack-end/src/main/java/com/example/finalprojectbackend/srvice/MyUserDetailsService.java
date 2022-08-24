package com.example.finalprojectbackend.srvice;

import com.example.finalprojectbackend.Repositry.UserRepositry;
import com.example.finalprojectbackend.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepositry personRepositre;

//    public MyUserDetailsService() {
//        super();
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users person=personRepositre.findPersonByUsername(username);
        if(person==null){
             throw new UsernameNotFoundException("Invalid username or password");
        }
        return person;
    }
}
