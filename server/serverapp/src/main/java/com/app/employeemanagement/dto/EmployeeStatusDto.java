package com.app.employeemanagement.dto;

import java.util.Date;

import com.app.employeemanagement.model.EmployeeStatus.Status;

public class EmployeeStatusDto {

	private EmployeeDto employee;
    private Status status;
    private Date dateJoin;
    private Date dateLeave;
    
    public EmployeeStatusDto() {
    	
    }

	public EmployeeStatusDto(EmployeeDto employee, Status status, Date dateJoin, Date dateLeave) {
		super();
		this.employee = employee;
		this.status = status;
		this.dateJoin = dateJoin;
		this.dateLeave = dateLeave;
	}

	public EmployeeDto getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
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
