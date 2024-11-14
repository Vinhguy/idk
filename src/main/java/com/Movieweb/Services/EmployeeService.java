package com.Movieweb.Services;

import com.Movieweb.DTO.Requests.EmployeeCreationRequest;
import com.Movieweb.DTO.Response.EmployeeResponse;
import com.Movieweb.Mapper.EmployeeMapper;
import com.Movieweb.Models.Employee;
import com.Movieweb.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    EmployeeMapper employeeMapper;


    public List<EmployeeResponse> getEmployee() {
        List<Employee> employees = employeeRepo.findAll();

        if (employees.isEmpty()) {
            throw new RuntimeException("No employees found");
        }

        List<EmployeeResponse> employeeResponses = employees.stream()
                .map(employeeMapper::toEmployeeResponse)
                .collect(Collectors.toList());


        if (employeeResponses.isEmpty()) {
            throw new RuntimeException("Mapping failed, no EmployeeResponses were created");
        }

        return employeeResponses;
    }


    public EmployeeResponse getEmployee(long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Wrong id"));
        return employeeMapper.toEmployeeResponse(employee);
    }

    public EmployeeResponse createEmployee(EmployeeCreationRequest request) {
        if(employeeRepo.existsByEmployeeName(request.getEmployeeName())) {
            throw new RuntimeException("Employee already exists");
        }

        Employee employee = employeeMapper.toEmployee(request);
        PasswordEncoder encoder = new BCryptPasswordEncoder(6);
        employee.setPassword(encoder.encode(request.getPassword()));
        return employeeMapper.toEmployeeResponse(employeeRepo.save(employee));
    }
}
