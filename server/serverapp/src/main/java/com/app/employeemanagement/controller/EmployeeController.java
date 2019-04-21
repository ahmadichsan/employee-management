package com.app.employeemanagement.controller;

import com.app.employeemanagement.model.Employee;
import com.app.employeemanagement.dto.EmployeeDto;
import com.app.employeemanagement.dto.RegisterDto;
import com.app.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PreAuthorize("hasRole('admin')")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<Employee> listUser() {
		return employeeService.findAll();
	}

	@PreAuthorize("hasRole('staff')")
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public Employee getOne(@PathVariable(value = "id") Long id) {
		return employeeService.findById(id);
	}

	@RequestMapping(value = "/add-employee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {
		try {
			if (!"MALE".equals(registerDto.getGender()) && !"FEMALE".equals(registerDto.getGender())) {
				return ResponseEntity.badRequest().body("unknown keyword for the gender");
			}
			employeeService.save(registerDto);
			return ResponseEntity.ok().body("insert done");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/edit-employee/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> upadte(@PathVariable(value = "id") Long id, @RequestBody EmployeeDto employeeDto) {
		try {
			employeeService.update(id, employeeDto);
			return ResponseEntity.ok().body("update done");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
