package com.abcteam.customerservice.controller;

import com.abcteam.customerservice.model.Credentials;
import com.abcteam.customerservice.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CustomerController {

    LoginService loginService;

    CustomerController(LoginService service) {
        this.loginService = service;
    }

    @GetMapping("/test")
    public void sampleFunction() {
        System.out.println("Hello");
    }

    @PostMapping(value = "/test1")
    public ResponseEntity sampleFunction1(@RequestBody Credentials credentials) {
        this.loginService.login(credentials);
        return new ResponseEntity<String>("User created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/test2/{name}")
    public Credentials sampleFunction2(@PathVariable("name") String name) {

        return this.loginService.getUserDetails(name);
    }


}
