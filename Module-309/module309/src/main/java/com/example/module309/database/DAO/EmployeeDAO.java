package com.example.module309.database.DAO;

import com.example.module309.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e where e.firstName = :firstName")
    List<Employee> findByFirstName(String firstName);
}
