package com.example.finalprojectbackend.controller;

import com.example.finalprojectbackend.Otd.ApiResponce;
import com.example.finalprojectbackend.model.OrderOfUser;
import com.example.finalprojectbackend.model.Places;
import com.example.finalprojectbackend.model.Users;
import com.example.finalprojectbackend.srvice.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    public final OrderService orderService;
    //crud(create,read,update,delete)+Show all user orders
//create oreder
    @PostMapping("/{placeid}")
    public ResponseEntity addorder(@PathVariable Integer placeid, @AuthenticationPrincipal Users users){

        orderService.addorder(placeid,users);
        return ResponseEntity.status(200).body(new ApiResponce("You Ordered Successfully !",200));

    }
    //user can see all his
    @GetMapping("/All")
    public List<OrderOfUser> showalluserorders(@AuthenticationPrincipal Users users) {

        return orderService.showalluserorders(users);
    }

    @DeleteMapping("/delete")
    public void deleteorder(Integer orderid,@AuthenticationPrincipal Users users){
        orderService.deleteorder(orderid,users);
    }
//    @GetMapping("/{id}")
//    public List<Orders> findallbypersonid(@PathVariable String id){
//
//        return orderService.findAllByPersonId(id);
//    }


}
