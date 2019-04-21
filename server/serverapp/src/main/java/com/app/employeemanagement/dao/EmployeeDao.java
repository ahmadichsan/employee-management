package com.app.employeemanagement.dao;

import com.app.employeemanagement.model.Employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {
    
    // add employee
    
    // get all employee
    
    // get employee detail/by id
	Optional<Employee> findById(Long id);
    
    // edit employee
    
    // delete employee => resign employee
}
