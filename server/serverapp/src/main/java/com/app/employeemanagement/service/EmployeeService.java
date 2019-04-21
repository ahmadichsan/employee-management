package com.app.employeemanagement.service;

import com.app.employeemanagement.model.Employee;
import com.app.employeemanagement.dto.EmployeeDto;
import com.app.employeemanagement.dto.RegisterDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee save(RegisterDto user) throws Exception;

    List<Employee> findAll();

    Employee findById(Long id);
    
    Employee update(Long id, EmployeeDto employeeDto) throws Exception;
}
