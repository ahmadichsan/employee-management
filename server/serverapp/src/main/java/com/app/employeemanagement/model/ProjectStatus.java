package com.app.employeemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project_status")
public class ProjectStatus {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_status_name", nullable = false)
    private String projectStatusName;
    // proposal, requirement, development, done, maintenance, cancel
    
    public ProjectStatus() {
    	
    }
    
	public ProjectStatus(Long id, String projectStatusName) {
		super();
		this.id = id;
		this.projectStatusName = projectStatusName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectStatusName() {
		return projectStatusName;
	}

	public void setProjectStatusName(String projectStatusName) {
		this.projectStatusName = projectStatusName;
	}
}
