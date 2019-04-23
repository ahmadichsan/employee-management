package com.app.employeemanagement.service;

import com.app.employeemanagement.model.Employee;
import com.app.employeemanagement.dto.EmployeeDto;
import com.app.employeemanagement.dto.RegisterDto;

import java.util.List;

public interface EmployeeService {

    Employee save(RegisterDto user) throws Exception;

    List<EmployeeDto> findAll() throws Exception;

    EmployeeDto findById(Long id) throws Exception;
    
    Employee update(Long id, EmployeeDto employeeDto) throws Exception;
    
    Employee findByLoginId(Long id) throws Exception;
}
