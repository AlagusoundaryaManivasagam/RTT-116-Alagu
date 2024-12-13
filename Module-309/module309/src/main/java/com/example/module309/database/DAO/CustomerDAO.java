package com.example.module309.database.DAO;

import com.example.module309.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where c.contactFirstname= :firstName")
    List<Customer> findByFirstName(String firstName);

    @Query("select c from Customer c where c.city = :city")
    List<Customer> findByCity(String city);

}


