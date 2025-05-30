package com.example.module309.controller;

import com.example.module309.database.DAO.EmployeeDAO;
import com.example.module309.database.DAO.OfficeDOA;
import com.example.module309.database.entity.Customer;
import com.example.module309.database.entity.Employee;
import com.example.module309.database.entity.Office;
import com.example.module309.form.CreateCustomerFormBean;
import com.example.module309.form.CreateEmployeeFormBean;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private OfficeDOA officeDOA;

    @GetMapping("/employee/search")
    public ModelAndView search(@RequestParam(required = false) String firstName) {
        ModelAndView response = new ModelAndView("search");
        int x = 10 / 0;
        //This is translating to WEB-INF/customer/search
        response.setViewName("employee/search");
        //add the search field to model so we can use it on jsp page
        response.addObject("searchTerm", firstName);
        if (firstName != null) {
            List<Employee> employees = employeeDAO.findByFirstName(firstName);
            response.addObject("employeeKey", employees);
        }
        return response;
    }

    @GetMapping("/employee/create")
    public ModelAndView create() {
        //This is just to show the create the page for the first time when user goes to the page
        ModelAndView response = new ModelAndView();
        response.setViewName("employee/create");
        return response;
    }

    @GetMapping("/employee/edit/{employeeId}")
    public ModelAndView editEmployee(@PathVariable Integer employeeId) {
        ModelAndView response = new ModelAndView();
        response.setViewName("employee/create");
        LOG.debug("============Editing employee " + employeeId);
        Employee employee = employeeDAO.findById(employeeId);
        CreateEmployeeFormBean form = new CreateEmployeeFormBean();
        form.setId(employee.getId());
        form.setFirstName(employee.getFirstName());
        form.setEmail(employee.getEmail());
        form.setExtension(employee.getExtension());
        form.setJobTitle(employee.getJobTitle());
        form.setLastName(employee.getLastname());
        response.addObject("form", form);
        return response;
    }

    @GetMapping("employee/create-employee")
    public ModelAndView createEmployeeSubmit(@Valid CreateEmployeeFormBean form, BindingResult bindingResult) {
        //jsr 303 is a specification  number
        //the data from url is transferred to the form bean
        //handler mapping does this job
        ModelAndView response = new ModelAndView();

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                LOG.debug(error.toString());
            }

            response.setViewName("employee/create");
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
        } else {
            Employee employee = employeeDAO.findById(form.getId());
            if (employee == null) {
                employee = new Employee();
            }
            employee.setFirstName(form.getFirstName());
            employee.setLastname(form.getLastName());
            employee.setEmail(form.getEmail());
            employee.setExtension(form.getExtension());
            employee.setJobTitle(form.getJobTitle());

            Office office = officeDOA.findById(1);
            employee.setOfficeId(office.getId());
            employeeDAO.save(employee);
            LOG.debug("==================creating employee" + employee.getId());
            response.setViewName("redirect:/employee/edit/" + employee.getId());
        }
        return response;
    }
}
