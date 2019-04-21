package com.app.employeemanagement.dto;

public class UnitDto {

	private String unitName;

	public UnitDto() {
		
	}
	
	public UnitDto(String unitName) {
		super();
		this.unitName = unitName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
}
