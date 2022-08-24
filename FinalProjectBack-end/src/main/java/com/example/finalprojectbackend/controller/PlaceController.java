package com.example.finalprojectbackend.controller;

import com.example.finalprojectbackend.Otd.ApiResponce;
import com.example.finalprojectbackend.model.Places;
import com.example.finalprojectbackend.model.Users;
import com.example.finalprojectbackend.srvice.PlacesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/place")
public class PlaceController {

    private final PlacesService placesService;

//
    //Admin can add places
    @PostMapping("/add")
    public ResponseEntity addplace(@RequestBody @Valid Places placess, @AuthenticationPrincipal Users users){

        placesService.Addplace(placess,users);
        return ResponseEntity.status(201).body(new ApiResponce("The new place is added !",201));

    }
    //admin can update place information
    @PostMapping("/update/{index}")
    public ResponseEntity updateplace(@RequestBody @Valid Places places,@AuthenticationPrincipal Users users,@PathVariable Integer index){

        placesService.updateplace(places,users,index);
        return ResponseEntity.status(201).body(new ApiResponce("The  place is updated !",201));

    }
    //admin can delete places
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delteteplace(@AuthenticationPrincipal Users users,@PathVariable  Integer id){
        placesService.deleteplace(users,id);
        return ResponseEntity.status(200).body(new ApiResponce("The  place is deleted !",200));

    }
    @GetMapping("/location")
    public ResponseEntity SearchbyLocation(@RequestParam String lo){

        return ResponseEntity.status(200).body(placesService.SearchbyLocation(lo));
    }
    //Users can search by location and type
    @GetMapping("/type")
    public ResponseEntity SearchbyLocationAndType(@RequestParam String location,@RequestParam String type){

        return ResponseEntity.status(200).body(placesService.SearchbyLocationAndType(location,type));
    }
//    //admin can see all his places
//    @GetMapping
//    public List<Places> findAllByAdminId(@AuthenticationPrincipal Users users){
//
//        return placesService.findAllByAdminId(users);
//
//    }



}
