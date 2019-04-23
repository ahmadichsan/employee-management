package com.app.employeemanagement.controller;

import com.app.employeemanagement.dto.LoginDto;
import com.app.employeemanagement.dto.LoginResDto;
import com.app.employeemanagement.dto.RoleDto;
import com.app.employeemanagement.dto.TokenDto;
import com.app.employeemanagement.dto.UnitDto;
import com.app.employeemanagement.model.Employee;
import com.app.employeemanagement.model.Login;
import com.app.employeemanagement.service.EmployeeService;
import com.app.employeemanagement.service.JwtTokenService;
import com.app.employeemanagement.service.LoginService;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenUtil;
    
    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    LoginService loginService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) throws AuthenticationException {
    	LoginResDto loginResDto = new LoginResDto();
    	Login login = new Login();
    	RoleDto roleDto = new RoleDto();
    	UnitDto unitDto = new UnitDto();
    	
    	Employee employee;
    	
    	try {
    		login = loginService.findByEmail(loginDto.getEmail());
    		login.setLastLogin(new Date());
		
			employee = employeeService.findByLoginId(login.getId());
			BeanUtils.copyProperties(employee, loginResDto, "role", "unit");
			
			roleDto.setRoleName(employee.getRole().getRoleName());
			unitDto.setUnitName(employee.getUnit().getUnitName());
	    	loginResDto.setRole(roleDto);
	    	loginResDto.setUnit(unitDto);
	    	loginResDto.setEmail(loginDto.getEmail());
	    	
	        final Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginDto.getEmail(),
	                        loginDto.getPassword()
	                )
	        );
	        
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        final String token = jwtTokenUtil.generateToken(authentication);
	        TokenDto authToken = new TokenDto(token);
	        loginResDto.setToken(authToken.getToken());
	        
	        loginService.save(login);
	        return ResponseEntity.ok().body(loginResDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    	
        
    }

}
