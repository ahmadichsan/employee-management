package com.app.employeemanagement.service;

import com.app.employeemanagement.model.Login;

public interface LoginService {

	Login findByEmail(String email) throws Exception;
	
	Login save(Login login) throws Exception;
}
