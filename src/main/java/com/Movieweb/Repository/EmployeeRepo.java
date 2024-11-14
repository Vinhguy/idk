package com.Movieweb.Repository;


import com.Movieweb.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    boolean existsByEmployeeName(String EmployeeName);
}
