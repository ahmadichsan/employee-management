package com.app.employeemanagement.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.employeemanagement.dao.LoginDao;
import com.app.employeemanagement.model.Employee;
import com.app.employeemanagement.model.Login;
import com.app.employeemanagement.service.EmployeeService;
import com.app.employeemanagement.service.LoginService;

@Service(value = "loginService")
public class LoginServiceImpl implements UserDetailsService, LoginService {

	@Autowired
	LoginDao loginDao;
	
	@Autowired
	EmployeeService employeeService;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Login login = loginDao.findByEmail(email);
		if(login == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(login.getEmail(), login.getPassword(), getAuthority(login));
	}

	private Set<SimpleGrantedAuthority> getAuthority(Login login) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        Employee employee;
		try {
			employee = employeeService.findByLoginId(login.getId());
			authorities.add(new SimpleGrantedAuthority("ROLE_" + employee.getRole().getRoleName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
        return authorities;
	}

	@Override
	public Login findByEmail(String email) throws Exception {
		Login login;
		try {
			login = loginDao.findByEmail(email);	
		} catch (Exception e) {
			throw new Exception(e);
		}
		return login;
	}
	
	@Override
	public Login save(Login login) throws Exception {
		try {
			loginDao.save(login);	
		} catch (Exception e) {
			throw new Exception(e);
		}
		return login;
	}
}
