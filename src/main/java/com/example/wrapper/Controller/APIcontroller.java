package com.example.wrapper.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.wrapper.Entity.Request;
import com.example.wrapper.Services.EntityService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/wrapper")
public class APIcontroller {
    EntityService entityService = new EntityService();

    @PostMapping("/add")
    public int add(@RequestBody Request objectRequest) {
        //TODO: process POST request
        return entityService.addition(objectRequest);
        
    }

    @PostMapping("/substract")
    public int substract(@RequestBody Request objectRequest) {
        //TODO: process POST request
        return entityService.subtraction(objectRequest);
    }

    @PostMapping("/multiply")
    public int multiply(@RequestBody Request objectRequest) {
        //TODO: process POST request
        
        return entityService.multiplication(objectRequest);
    }

    @PostMapping("/division")
    public int divide(@RequestBody Request objectRequest) {
        //TODO: process POST request
        
        return entityService.division(objectRequest);
    }
    
    
    


    
}
