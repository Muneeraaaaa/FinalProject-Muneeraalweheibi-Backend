package com.example.finalprojectbackend.Repositry;

import com.example.finalprojectbackend.model.OrderOfUser;
import com.example.finalprojectbackend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrederRepositry extends JpaRepository<OrderOfUser,Integer> {

    List<OrderOfUser> findAllByPersonId(Integer userid);
    OrderOfUser findOrderOfUserById(Integer id);


}
