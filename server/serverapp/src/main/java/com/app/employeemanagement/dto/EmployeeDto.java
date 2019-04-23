package com.app.employeemanagement.dto;

import java.util.Date;

public class EmployeeDto {

    private String name;
    private String gender;
    private Date dob;
    private String address;
    private long salary;
    private Long role;
    private Long unit;
    private Long login;
    
    public EmployeeDto() {
    	
    }

	public EmployeeDto(String name, String gender, Date dob, String address, long salary, Long role, Long unit,
			Long login) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.salary = salary;
		this.role = role;
		this.unit = unit;
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}

	public Long getUnit() {
		return unit;
	}

	public void setUnit(Long unit) {
		this.unit = unit;
	}

	public Long getLogin() {
		return login;
	}

	public void setLogin(Long login) {
		this.login = login;
	}
}
