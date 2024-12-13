package com.example.module309.controller;
import com.example.module309.database.entity.Customer;
import com.example.module309.database.DAO.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerDAO customerDAO;
    @GetMapping("/customer/search")
    public ModelAndView search(@RequestParam(required = false) String firstName) {
        ModelAndView response = new ModelAndView("search");
        //This is translating to WEB-INF/customer/search
        response.setViewName("customer/search");
        //add the search field to model so we can use it on jsp page
        response.addObject("searchTerm", firstName);
        if(firstName != null){
            List<Customer> customers = customerDAO.findByFirstName(firstName);
            response.addObject("customerKey", customers);
        }
        return response;
    }
}
