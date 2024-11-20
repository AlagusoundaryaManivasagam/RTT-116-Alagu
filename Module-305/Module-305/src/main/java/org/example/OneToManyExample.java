package org.example;

import org.example.database.dao.EmployeeDAO;

import org.example.database.entity.Customer;
import org.example.database.entity.Employee;



public class OneToManyExample {
    public static void main(String[] args){
        EmployeeDAO employeeDAO = new EmployeeDAO();

        // this runs a query and session is closed
        Employee e = employeeDAO.findById(1501);

        System.out.println(e);
        for(Customer c : e.getCustomers()){
            System.out.println(c);
            System.out.println(c.getEmployee());
        }

        // add a new customer to employee using hibernate
        // first we create the new customer entity and fill it with data
        Customer newCustomer = new Customer();
        newCustomer.setCustomerName("New Customer");
        newCustomer.setContactFirstname("Alagu");
        newCustomer.setContactLastname("Manivasagam");
        newCustomer.setPhone("1234567");
        newCustomer.setAddressLine1("1111111111111111");
        newCustomer.setAddressLine2("1111111111111111");
        newCustomer.setCity("asdf");
        newCustomer.setState("asdf");
        newCustomer.setPostalCode("12235");
        newCustomer.setCountry("USA");
        newCustomer.setCreditLimit(15);

        // this is a gotcha , we are setting employee on
        // new customer eventhough you are adding the new customer
        // to the the list of customers for an employee
        newCustomer.setEmployee(e);
        //this will not work because sales rep employee id is  not insertable and not updateable
        // newCustomer.setSalesRepEmployeeId(1054);
        //add customer to list of customer list of the employee
        e.getCustomers().add(newCustomer);

        //then we save the employee
        employeeDAO.updateEmployee(e);

    }
}
