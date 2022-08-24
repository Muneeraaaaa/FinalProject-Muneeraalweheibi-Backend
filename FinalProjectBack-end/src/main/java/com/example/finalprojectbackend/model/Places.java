package com.example.finalprojectbackend.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;

@AllArgsConstructor @RequiredArgsConstructor @Data
@Entity
public class Places {

//    +location: String
//+LocationSize: String
//+KindOfStorage: String
//-price: Integer
//-Duration:String
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer AdminId;
    public String location;
    public String LocationSize;
    //check (food,clothing,veichels)
    public String kindOfStorage;
    public Integer Price;
    public String duration;




}
