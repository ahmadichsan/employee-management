package com.app.employeemanagement.dto;

import java.util.Date;

public class EmployeeDto {

    private String name;
    private String gender;
    private Date dob;
    private String address;
    private long salary;
    private int role;
    private int unit;
    private int login;
    
    public EmployeeDto() {
    	
    }

	public EmployeeDto(String name, String gender, Date dob, String address, long salary, int role, int unit,
			int login) {
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}
}
