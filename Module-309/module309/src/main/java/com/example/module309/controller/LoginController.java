package com.example.module309.controller;


import jakarta.persistence.Column;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LoginController {

    //This fet mapping is called by spring security when a secure resource is requested
    //needs to match the spring security configuration
    @GetMapping("/login/login")
    public ModelAndView theLoginPage() {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/loginPage");
        return response;
    }

    @GetMapping("/login/create")
    public ModelAndView customerCreate() {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/create");
        return response;
    }
}
