package com.example.finalprojectbackend.srvice;

import com.example.finalprojectbackend.Repositry.OrederRepositry;
import com.example.finalprojectbackend.model.OrderOfUser;
import com.example.finalprojectbackend.model.Places;
import com.example.finalprojectbackend.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    public final OrederRepositry orederRepositry;

    public void addorder(Integer placeid,Users users){
        OrderOfUser neworder=new OrderOfUser(null,placeid,users.getId());
    }
    public List<OrderOfUser> showalluserorders(Users users){

      return   orederRepositry.findAllByPersonId(users.getId());

    }

    public void deleteorder(Integer id,Users users){

        OrderOfUser thedeletedone=orederRepositry.findOrderOfUserById(id);

//        if (users.getId().equals(order.getPersonId()))
        orederRepositry.delete(thedeletedone);
//        else
//            its not his order

    }
//    public List<Orders> findAllByPersonId(String personid){
//
//        return orederRepositry.findAllByPersonId(personid);
//
//    }


}
