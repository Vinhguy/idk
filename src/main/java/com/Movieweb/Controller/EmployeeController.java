package com.Movieweb.Controller;

import com.Movieweb.DTO.Requests.EmployeeCreationRequest;
import com.Movieweb.DTO.Requests.MovieCreationRequest;
import com.Movieweb.DTO.Response.ApiResponse;
import com.Movieweb.DTO.Response.EmployeeResponse;
import com.Movieweb.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    EmployeeService employeeService;
    @Autowired
    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/all")
    public ApiResponse<List> getEmployees() throws IllegalStateException{
        ApiResponse<List> apiResponse = new ApiResponse<>();
        apiResponse.setResult(employeeService.getEmployee());
        return apiResponse;
    }
    @PostMapping("/create")
    public ApiResponse<EmployeeResponse> createEmployee(@RequestBody EmployeeCreationRequest request){
        ApiResponse<EmployeeResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(employeeService.createEmployee(request));
        return apiResponse;
    }
}
