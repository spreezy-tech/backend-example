package com.abcteam.customerservice.controller;

import com.abcteam.customerservice.model.Credentials;
import com.abcteam.customerservice.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    LoginService loginService;

    TestController(LoginService service){
        this.loginService = service;
    }

    @GetMapping("/test")
    public void sampleFunction(){
        System.out.println("Hello");
    }

    @PostMapping("/test1")
    public void sampleFunction1(@RequestBody Credentials credentials){
        this.loginService.login(credentials);
    }

    @GetMapping("/test2/{name}")
    public Credentials sampleFunction2(@PathVariable("name") String name){

        return this.loginService.getUserDetails(name);
    }



}
