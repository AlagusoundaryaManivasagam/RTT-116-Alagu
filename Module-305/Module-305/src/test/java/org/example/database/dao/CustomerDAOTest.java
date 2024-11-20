package org.example.database.dao;

import org.example.database.entity.Customer;
import org.example.database.entity.Employee;
import org.hibernate.annotations.Parameter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CustomerDAOTest {
    private CustomerDAO customerDOA = new CustomerDAO();
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    @Test
    public void findByIdTest(){
        // given
        int givenCustomerId = 125;
        // when
        Customer actual = customerDOA.findById(givenCustomerId);
        // then
        Assertions.assertEquals("Havel & Zbyszek Co",actual.getCustomerName());
        Assertions.assertEquals(givenCustomerId, actual.getId());
        Assertions.assertEquals(0.00, actual.getCreditLimit());
    }

    @Test
    public void createTest(){
        // given
        Customer given = new Customer();
        given.setCustomerName("New Customer");
        given.setContactFirstname("Alagu");
        given.setContactLastname("Manivasagam");
        given.setPhone("1234567");
        given.setAddressLine1("1111111111111111");
        given.setAddressLine2("1111111111111111");
        given.setCity("asdf");
        given.setState("asdf");
        given.setPostalCode("12235");
        given.setCountry("USA");
        given.setCreditLimit(15);
        Employee employee = employeeDAO.findById(1216);
        given.setEmployee(employee);

        // when
        // we want to make sure that given.getid is null before inserting to database
        Assertions.assertNull(given.getId());
        Customer actual = customerDOA.create(given);

        // then
        // asserting the object has an id
        Assertions.assertNotNull(actual.getId());
        // here the test should have failed because we set employee
        // but hibernate failed to update the sales rep employee id so this test passed
        Assertions.assertNull(actual.getSalesRepEmployeeId());
        Assertions.assertEquals(given.getContactFirstname(), actual.getContactFirstname());
        Assertions.assertEquals(given.getContactLastname(), actual.getContactLastname());
        // create an assertion to check if the employee id is correct
        Assertions.assertEquals(employee.getId(), actual.getEmployee().getId());

    }

    @ParameterizedTest
    @CsvSource({
            "103, Atelier graphique",
            "112, Signal Gift Stores",
            "114, 'Australian Collectors, Co.'"
    })

    public void findByIdTest(int customerId, String customerName){
        // this is to show how parameterizedTest
        // give
        // when
        Customer actual = customerDOA.findById(customerId);

        //then
        Assertions.assertEquals(customerName, actual.getCustomerName());
    }


}
