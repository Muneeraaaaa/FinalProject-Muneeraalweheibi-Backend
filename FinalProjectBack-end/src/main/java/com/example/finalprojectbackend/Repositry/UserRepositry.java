package com.example.finalprojectbackend.Repositry;

import com.example.finalprojectbackend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositry extends JpaRepository<Users,Integer> {

    Users findPersonByUsername(String username);
    Users findUsersById(Integer adminid);


}
