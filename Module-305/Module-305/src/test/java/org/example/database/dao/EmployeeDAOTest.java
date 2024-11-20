package org.example.database.dao;

import org.example.database.entity.Customer;
import org.example.database.entity.Employee;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDAOTest {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    @Test
    @Order(1)
    public void findByIdTest(){
        //given
        int givenEmployeeId = 1102;

        //when
        Employee actual = employeeDAO.findById(givenEmployeeId);

        //then
        Assertions.assertEquals("Bondur", actual.getLastname());
        Assertions.assertEquals("Gerard", actual.getFirstName());
        Assertions.assertEquals("gbondur@classicmodelcars.com", actual.getEmail());
    }

    @Test
    @Order(2)
    public void findByFirstNameTest(){
        //given
        String givenEmployeeFirstName = "Leslie";

        //when
        List<Employee> actual = employeeDAO.findByFirstName(givenEmployeeFirstName);

        //then
        Assertions.assertEquals(2, actual.size());
    }

    @Test
    @Order(3)
    public void createEmployeeTest(){
        //given
        Employee given = new Employee();
        given.setOfficeId(1);
        given.setLastname("Soundarya");
        given.setFirstName("Alagu");
        given.setExtension("x1234");
        given.setEmail("absc@gmail.com");
        given.setReportsTo(1056);
        given.setJobTitle("Sales Rep");
        given.setVacationHours(20);


        //when
        Assertions.assertNull(given.getId());
        Employee actual = employeeDAO.createEmployee(given);

        //then
        Assertions.assertNotNull(actual.getId());
        Assertions.assertEquals(given.getExtension(), actual.getExtension());
        Assertions.assertEquals(given.getEmail(), actual.getEmail());
        Assertions.assertEquals(given.getOfficeId(), actual.getOfficeId());
        Assertions.assertEquals(given.getFirstName(), actual.getFirstName());
        Assertions.assertEquals(given.getLastname(), actual.getLastname());
        Assertions.assertEquals(given.getJobTitle(),actual.getJobTitle());
    }

    @Test
    @Order(4)
    public void updateEmployeeTest(){
        //given
        Employee given = employeeDAO.findByEmail("absc@gmail.com");
        //when
        given.setLastname("Manivasagam");
        given.setVacationHours(30);
        Employee actual = employeeDAO.updateEmployee(given);
        //then
        Assertions.assertEquals(given.getLastname(),actual.getLastname());
        Assertions.assertEquals(given.getVacationHours(), actual.getVacationHours());
    }

    @Test
    @Order(5)
    public void deleteEmployeeTest(){
        //given
        //Employee given= employeeDAO.findByEmail("absc@gmail.com");
        //when
        //Assertions.assertNotNull(given);
        employeeDAO.deleteEmployee(employeeDAO.findByEmail("absc@gmail.com"));
        //then
        //Assertions.assertNull(given);
        Assertions.assertNull(employeeDAO.findByEmail("absc@gmail.com"));

    }

    @ParameterizedTest
    @CsvSource({
            "1002, dmurphy@classicmodelcars.com",
            "1056, mpatterso@classicmodelcars.com",
            "1076, jfirrelli@classicmodelcars.com"
    })

    public void findByIdTest(int employeeId, String email){
        // this is to show how parameterizedTest
        // give
        // when
        try{
            Employee actual = employeeDAO.findById(employeeId);
            Assertions.assertEquals(email, actual.getEmail());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //then

    }
}
