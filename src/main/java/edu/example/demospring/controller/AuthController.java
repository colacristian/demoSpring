package edu.example.demospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : colacristian on 11/13/22
 **/
@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
