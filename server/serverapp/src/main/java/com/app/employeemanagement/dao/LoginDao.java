package com.app.employeemanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.employeemanagement.model.Login;

public interface LoginDao extends JpaRepository<Login, Long> {

	Login findByEmail(String email);
}
