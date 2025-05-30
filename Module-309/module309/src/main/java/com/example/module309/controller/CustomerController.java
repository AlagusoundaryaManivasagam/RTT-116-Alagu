package com.example.module309.controller;

import com.example.module309.database.DAO.EmployeeDAO;
import com.example.module309.database.entity.Customer;
import com.example.module309.database.DAO.CustomerDAO;
import com.example.module309.database.entity.Employee;
import com.example.module309.form.CreateCustomerFormBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

//@Slf4j
//severity increases as going down
//as developers we mostly use DEBUG
//TRACE - this is low level and not used by us. more for creators of libraries
//DEBUG-
//INFO - info that is printed when by spring when it starts up
//WARN - potential problem but not error
//ERROR - failed API call or exception
//FATAL- unrecoverable error
//it is a specification of logging not an implementation
// most if not all other logging libraries have come to use this specification for
@Controller
public class CustomerController {
    //this is old style of logging before lombak but its bit problem because we have to write the correct class name.
    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/customer/search")
    public ModelAndView search(@RequestParam(required = false) String firstName) {
        ModelAndView response = new ModelAndView("search");

        //This is translating to WEB-INF/customer/search
        response.setViewName("customer/search");
        //we can manually set some validations here
        //add the search field to model so we can use it on jsp page
        response.addObject("searchTerm", firstName);
        if (firstName != null) {
            List<Customer> customers = customerDAO.findByFirstName(firstName);
            response.addObject("customerKey", customers);
        }
        return response;
    }

    @GetMapping("/customer/ajaxExample")
    public ModelAndView ajaxExample() {
        ModelAndView response = new ModelAndView();
        response.setViewName("customer/ajaxExample");
        return response;
    }

    @ResponseBody//It means it will not generate view, it just will take json to browser
    @GetMapping("/customer/ajaxCall")
    public String ajaxCall(@RequestParam Integer customerId) throws JsonProcessingException {
        Customer customer = customerDAO.findById(customerId);


        String json = new ObjectMapper().writeValueAsString(customer);

        return json;
    }

    @GetMapping("/customer/create")
    public ModelAndView create() {


        //This is just to show the create the page for the first time when user goes to the page
        ModelAndView response = new ModelAndView();
        List<Employee> employees = employeeDAO.findAllEmployees();
        response.addObject("employeesKey", employees);
        response.setViewName("customer/create");
        return response;
    }

    //page primer for edit
    @GetMapping("/customer/edit/{customerId}")
    public ModelAndView editCustomer(@PathVariable Integer customerId) {
        ModelAndView response = new ModelAndView();
        response.setViewName("customer/create");
        LOG.debug("============Editing customer " + customerId);
        Customer customer = customerDAO.findById(customerId);
        CreateCustomerFormBean form = new CreateCustomerFormBean();
        form.setId(customer.getId());
        form.setCompanyName(customer.getCustomerName());
        form.setCity(customer.getCity());
        form.setCountry(customer.getCountry());
        form.setPhone(customer.getPhone());
        form.setAddressLine1(customer.getAddressLine1());
        form.setFirstName(customer.getContactFirstname());
        form.setLastName(customer.getContactLastname());
        form.setEmployeeId(customer.getSalesRepEmployeeId());
        //alternate
        //form.setEmployeeId(customer.getEmployee().getId());
        response.addObject("form", form);

        List<Employee> employees = employeeDAO.findAllEmployees();
        response.addObject("employeesKey", employees);

        return response;
    }

    //page primer for create
    @PostMapping("customer/create-customer")
    public ModelAndView createCustomerSubmit(@Valid CreateCustomerFormBean form, BindingResult bindingResult) throws IOException {
        //jsr 303 is a specification  number
        //the data from url is transferred to the form bean
        //handler mapping does this job
        ModelAndView response = new ModelAndView();


        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                LOG.debug(error.toString());
            }
            response.setViewName("customer/create");
            List<Employee> employees = employeeDAO.findAllEmployees();
            response.addObject("employeesKey", employees);
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
        } else {
            //when this is a create the id in the form will be null
            //when it is an edit form will have id
            // if it is not found in db then its create
            // if found its edit
            Customer customer = customerDAO.findById(form.getId());
            if (customer == null) {
                customer = new Customer();
            }

            // here we are going to deal with saving the upload file to the disk
            LOG.debug("uploaded filename = " + form.getUpload().getOriginalFilename() + " size = " + form.getUpload().getSize());
// create a new file object that represents the location to save the upload to
// we know that intellij always assumes the current working directory is the root of the project so we are making
// a relative URL To the images folder within our project
            String pathToSave = "./src/main/webapp/pub/images/" + form.getUpload().getOriginalFilename();
            // this is a java utility that will read the file from the upload and write it to the file we created above
// will not take the entire file into memory
            Files.copy(form.getUpload().getInputStream(), Paths.get(pathToSave), StandardCopyOption.REPLACE_EXISTING);
// this is the url that we will use to display the image in the browser
// it is an absolute URL based on the webapp folder as it would be used in the html
            String url = "/pub/images/" + form.getUpload().getOriginalFilename();
            customer.setImageUrl(url);

            System.out.println("Customer Form = " + form);

            customer.setCustomerName(form.getCompanyName());
            customer.setContactFirstname(form.getFirstName());
            customer.setContactLastname(form.getLastName());
            customer.setPhone(form.getPhone());
            customer.setAddressLine1(form.getAddressLine1());
            customer.setCity(form.getCity());
            customer.setCountry(form.getCountry());

            Employee employee = employeeDAO.findById(form.getEmployeeId());
            customer.setEmployee(employee);
            customerDAO.save(customer);
            LOG.debug("============creating customer " + customer.getId());
            // we want to be redirected to the edit url
            response.setViewName("redirect:/customer/edit/" + customer.getId());

        }
        return response;
    }


}
