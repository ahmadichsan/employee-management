package com.app.employeemanagement.serviceImpl;

import com.app.employeemanagement.dao.EmployeeDao;
import com.app.employeemanagement.dao.EmployeeStatusDao;
import com.app.employeemanagement.dao.LoginDao;
import com.app.employeemanagement.model.Employee;
import com.app.employeemanagement.model.EmployeeStatus;
import com.app.employeemanagement.model.EmployeeStatus.Status;
import com.app.employeemanagement.model.Login;
import com.app.employeemanagement.model.Role;
import com.app.employeemanagement.model.Unit;
import com.app.employeemanagement.dto.EmployeeDto;
import com.app.employeemanagement.dto.RegisterDto;
import com.app.employeemanagement.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.transaction.Transactional;


@Service(value = "employeeService")
public class EmployeeServiceImpl implements UserDetailsService, EmployeeService {
//public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private EmployeeStatusDao employeeStatusDao;
	
	@Autowired
	private LoginDao loginDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Login employee = loginDao.findByEmail(username);
//		if(employee == null){
//			throw new UsernameNotFoundException("Invalid username or password.");
//		}
//		return new org.springframework.security.core.userdetails.User(employee.getEmail(), employee.getPassword(), getAuthority(employee));
		return null;
	}

	private Set<SimpleGrantedAuthority> getAuthority(Employee user) {
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getRoleName()));
//        return authorities;
		return null;
	}
	
	@Override
	@Transactional(rollbackOn = {Exception.class})
    public Employee save(RegisterDto registerDto) throws Exception {
	    Employee newEmployee = new Employee();
	    Login newLogin = new Login();
	    Role newRole = new Role();
	    Unit newUnit = new Unit();
	    EmployeeStatus newEmployeeStatus = new EmployeeStatus();
	    try {
	    	newLogin.setEmail(registerDto.getEmail());
	    	newLogin.setPassword(bcryptEncoder.encode(registerDto.getPassword()));
	    	newLogin.setLastLogin(new Date());

	    	newRole.setId(registerDto.getRole());
	    	if (registerDto.getRole().intValue() == 1) newRole.setRoleName("OWNER");
	    	if (registerDto.getRole().intValue() == 2) newRole.setRoleName("SUPER_ADMIN");
	    	if (registerDto.getRole().intValue() == 3) newRole.setRoleName("ADMIN");
	    	if (registerDto.getRole().intValue() == 4) newRole.setRoleName("USER");
	    	
	    	newUnit.setId(registerDto.getUnit());
	    	if (registerDto.getUnit().intValue() == 1) newRole.setRoleName("DEVELOPMENT");
	    	if (registerDto.getUnit().intValue() == 2) newRole.setRoleName("BUSINESS");
	    	if (registerDto.getUnit().intValue() == 3) newRole.setRoleName("GENERAL");
	    	
	    	Status status = Status.valueOf(registerDto.getStatus());
	    	Calendar cal = Calendar.getInstance();
	    	cal.set(Calendar.YEAR, 1988);
	    	cal.set(Calendar.MONTH, Calendar.DECEMBER);
	    	cal.set(Calendar.DAY_OF_MONTH, 31);
	    	Date dateLeave = cal.getTime();
	    	newEmployeeStatus.setDateJoin(registerDto.getDateJoin());
	    	newEmployeeStatus.setDateLeave(dateLeave);
	    	newEmployeeStatus.setStatus(status);
	    	
	    	BeanUtils.copyProperties(registerDto, newEmployee, "email", "password");
	    	newEmployee.setRole(newRole);
	    	newEmployee.setUnit(newUnit);
	    	newEmployee.setGender(registerDto.getGender());

	    	loginDao.save(newLogin);
	    	loginDao.flush();
	    	
	    	newEmployee.setLogin(newLogin);
	    	
	    	employeeDao.save(newEmployee);
	    	employeeDao.flush();
	    	
	    	newEmployeeStatus.setEmployeeId(newEmployee);
	    	employeeStatusDao.save(newEmployeeStatus);
	    } catch (Exception e) {
	    	throw new Exception(e);
	    }
        return null;
    }
	
	@Override
	public Employee findById(Long id) {
		return employeeDao.findById(id).get();
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> list = new ArrayList<>();
		employeeDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
	
	@Override
	public Employee update(Long id, EmployeeDto employeeDto) throws Exception {
		Employee employee;
		try {
			employee = employeeDao.findById(id).get();
			BeanUtils.copyProperties(employeeDto, employee);
			employeeDao.save(employee);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return employee;
	}

	// delete => update EmployeeStatusDao => set status to resign/fired
}
