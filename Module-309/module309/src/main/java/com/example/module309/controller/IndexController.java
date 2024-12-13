package com.example.module309.controller;

import com.example.module309.database.DAO.CustomerDAO;
import com.example.module309.database.entity.Customer;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
//name of function doesnt matter
//it can be anything we want
@Controller
public class IndexController {
    //every time a page is loaded its build through this process, its not stored on cache
    //The cache we see is from browser not from website
    //essentially springboot created the DAO for us and its already in  memory
    //all we have to do is to autowire it
    // it is analogus to when we created a DAO in module305
    @Autowired
    private CustomerDAO customerDAO;
    //The process is synchronous i.e step 3 doesn't start untill step 2 is done
    //the goal of this controller is to do
    //1.establish a view name if ther is to be an HTML page that goes with this
    //2.load any information from the database that i need to display on the page
    @GetMapping(value={"/index","/index123"})
    public ModelAndView index(@RequestParam(required = false) String search) {
        //url is the only way we make contact with backend
      //this is always the first line of function
        ModelAndView response = new ModelAndView();
        response.setViewName("index");
        List<Customer> firstNames = customerDAO.findByFirstName(search);
        for(Customer c : firstNames){
            System.out.println(c.toString());
        }
        //once I found what I need its added to the model and the model is the stuff for entity
        //model is nothing more than a hash map
        response.addObject("names", firstNames);
        //response.addObject("names","asdf");
        //when I am fone and the control is returned to dispatcher servlet
        //this is #5 in arcgitectural image
        return response;
        //Facebook doesn't use the view controller
        // in face book instead of giving view JSON is given
        //this is difference between MVC abd reactjs

    }
    @GetMapping("/courses/{courseId}/external_tools/{toolId}")
    //path variable is used only when the required data is confirmed to constraints of what is valid in url
    public ModelAndView pathVariable(@PathVariable String courseId, @PathVariable String toolId) {
        ModelAndView response = new ModelAndView();

        System.out.println(courseId + " .... " + toolId);

        response.setViewName("xyz789");

        return response;
    }


    @GetMapping("/requestParam")
    //request param is used when the data has spaces or special character etc.
    public ModelAndView requestParam(@RequestParam String seriesId, @RequestParam String season) {
        ModelAndView response = new ModelAndView();

        System.out.println(season + " .... " + seriesId);

        response.setViewName("xyz789");

        return response;
    }


    @ResponseBody
    @GetMapping("/index.JSON")
    public List<Customer> indexJSON(){
        //if we are working with react for a front end we might do something like this
        //because spring will convert it into JSON
        //in REACT we might create a specific DTO(DataTransport Object)
        List<Customer> firstNames = customerDAO.findByFirstName("Alexander");
        return firstNames;
    }
}
