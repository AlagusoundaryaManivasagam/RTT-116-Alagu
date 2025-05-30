package com.example.module309.database.DAO;

import com.example.module309.database.entity.Employee;
import com.example.module309.database.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeDOA extends JpaRepository<Office, Long> {
    Office findById(Integer id);
}
