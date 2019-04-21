package com.app.employeemanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.employeemanagement.model.Project;

public interface ProjectDao extends JpaRepository<Project, Long> {

	// add project
	
	// edit project
	
	// get all project
	
	// get project by id
	
	// delete project => done, cancel, hold
}
