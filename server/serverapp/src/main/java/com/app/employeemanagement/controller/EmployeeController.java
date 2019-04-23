package com.app.employeemanagement.controller;

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
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<EmployeeDto> findAll() throws Exception {
		return employeeService.findAll();
	}

	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public EmployeeDto findById(@PathVariable(value = "id") Long id) throws Exception {
		return employeeService.findById(id);
	}

	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody RegisterDto registerDto) {
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
	
	@PreAuthorize("hasRole('SUPER_ADMIN')")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody EmployeeDto employeeDto) {
		try {
			employeeService.update(id, employeeDto);
			return ResponseEntity.ok().body("update done");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
