package com.example.wrapper.Services;

import com.example.wrapper.Entity.Request;

public class EntityService {
    Request entity= new Request();
    operationservice operationservice = new operationservice();

    public int addition(Request request) {
        return operationservice.addition(request.a, request.b);
    }

    public int subtraction(Request request) {
        return operationservice.subtraction(request.a, request.b);
    }
    
    public int multiplication(Request request){
        return operationservice.multiplication(request.a, request.b);
    }

    public int division(Request request){
        return operationservice.division(request.a,request.b);
    }
}
