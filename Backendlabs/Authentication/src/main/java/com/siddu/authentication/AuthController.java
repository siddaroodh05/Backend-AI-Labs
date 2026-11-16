package com.siddu.authentication;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @GetMapping("/auth/login")
    public String login(){
        return "login successfully";
    }
}
