package com.Movieweb.Mapper;

import com.Movieweb.DTO.Requests.EmployeeCreationRequest;
import com.Movieweb.DTO.Response.EmployeeResponse;
import com.Movieweb.Models.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEmployee(EmployeeCreationRequest request);
    EmployeeResponse toEmployeeResponse(Employee employee);
}
