package com.Movieweb.Repository;


import com.Movieweb.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    boolean existsByUsername(String UserName);
    Optional<User> findByUsername(String Username);
}
