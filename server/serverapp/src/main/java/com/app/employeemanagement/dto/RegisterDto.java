package com.app.employeemanagement.dto;

import java.util.Date;

public class RegisterDto {

    private String name;
    private String gender;
    private Date dob;
    private String address;
    private long salary;
    private Long role;
    private Long unit;
    private String email;
    private String password;
    private String status;
    private Date dateJoin;
    private Date dateLeave;
    
    public RegisterDto() {
    	
    }

	public RegisterDto(String name, String gender, Date dob, String address, long salary, Long role, Long unit,
			String email, String password, String status, Date dateJoin, Date dateLeave) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.salary = salary;
		this.role = role;
		this.unit = unit;
		this.email = email;
		this.password = password;
		this.status = status;
		this.dateJoin = dateJoin;
		this.dateLeave = dateLeave;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateJoin() {
		return dateJoin;
	}

	public void setDateJoin(Date dateJoin) {
		this.dateJoin = dateJoin;
	}

	public Date getDateLeave() {
		return dateLeave;
	}

	public void setDateLeave(Date dateLeave) {
		this.dateLeave = dateLeave;
	}
}
