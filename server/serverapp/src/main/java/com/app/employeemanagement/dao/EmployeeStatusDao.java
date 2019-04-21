package com.app.employeemanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.employeemanagement.model.EmployeeStatus;

public interface EmployeeStatusDao extends JpaRepository<EmployeeStatus, Long> {

}
