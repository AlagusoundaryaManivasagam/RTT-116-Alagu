package org.example;

import org.example.database.dao.EmployeeDAO;
import org.example.database.entity.Employee;

public class EmployeeUpdate {
    public static void main(String[] args){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee e = employeeDAO.findByEmail("ljennings@classicmodelcars.com");
        System.out.println(e);

        //Employee e1 = employeeDAO.findByEmail("absc@gmail.com");
        employeeDAO.deleteEmployee( employeeDAO.findByEmail("absc@gmail.com"));

    }
}
