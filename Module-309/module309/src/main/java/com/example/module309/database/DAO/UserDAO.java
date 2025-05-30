package com.example.module309.database.DAO;

import com.example.module309.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {

    User findById(Integer id);

    User findByEmailIgnoreCase(String username);

}
