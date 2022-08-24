package com.example.finalprojectbackend.advice;

import com.example.finalprojectbackend.Otd.ApiException;
import com.example.finalprojectbackend.Otd.ApiResponce;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAdvise {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity apiException(ApiException apiException){
        return ResponseEntity.status(400).body(new ApiResponce(apiException.getMessage(),400));
    }


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception exception){
        exception.printStackTrace();
        return ResponseEntity.status(500).body(new ApiResponce("Server Error",500));
    }

}
