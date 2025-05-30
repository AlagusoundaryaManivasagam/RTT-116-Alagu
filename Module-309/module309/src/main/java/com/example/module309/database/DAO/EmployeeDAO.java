package com.example.module309.database.DAO;

import com.example.module309.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {
    //this is JPA/Hibernate/HQL/JQL
    @Query("select e from Employee e where e.firstName = :firstName")
    List<Employee> findByFirstName(String firstName);

    Employee findById(Integer id);

    @Query(value = "select * from employees order by lastname asc;", nativeQuery = true)
    List<Employee> findAllEmployees();

}
