package com.app.employeemanagement.dto;

import java.util.Date;

public class LoginResDto {
    
    private String name;
    private String gender;
    private Date dob;
    private String address;
    private long salary;
    private RoleDto role;
    private UnitDto unit;
    private String email;
    private String token;
    
    public LoginResDto() {
    	
    }

	public LoginResDto(String name, String gender, Date dob, String address, long salary, RoleDto role, UnitDto unit,
			String email, String token) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.salary = salary;
		this.role = role;
		this.unit = unit;
		this.email = email;
		this.token = token;
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

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

	public UnitDto getUnit() {
		return unit;
	}

	public void setUnit(UnitDto unit) {
		this.unit = unit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
