package com.example.module309.controller;

import com.example.module309.database.DAO.CustomerDAO;
import com.example.module309.database.entity.Customer;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {
    //essentially springboot created the DAO for us and its already in  memory
    //all we have to do is to autowire it
    // it is analogus to when we created a DAO in module305
    @Autowired
    private CustomerDAO customerDAO;
    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView response = new ModelAndView();
        response.setViewName("index");
        List<Customer> firstName = customerDAO.findByFirstName("Alexander");
        for(Customer c : firstName){
            System.out.println(c);
        }
        return response;
    }
}
