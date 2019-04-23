package com.app.employeemanagement.dao;

import com.app.employeemanagement.model.Employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {
    
	Optional<Employee> findById(Long id);
	
	Optional<Employee> findByLoginId(Long id);
}
