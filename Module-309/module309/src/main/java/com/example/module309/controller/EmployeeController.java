package com.example.module309.controller;

import com.example.module309.database.DAO.EmployeeDAO;
import com.example.module309.database.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;
    @GetMapping("/employee/search")
    public ModelAndView search(@RequestParam(required = false) String firstName){
        ModelAndView response = new ModelAndView("search");
        response.setViewName("employee/search");
        response.addObject("searchTerm", firstName);
        if (firstName != null) {
            List<Employee> employees = employeeDAO.findByFirstName(firstName);
            response.addObject("employeeKey",employees);
        }
        return response;
    }
}
