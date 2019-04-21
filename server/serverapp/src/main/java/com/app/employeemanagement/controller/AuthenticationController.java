package com.app.employeemanagement.controller;

import com.app.employeemanagement.dto.LoginDto;
import com.app.employeemanagement.dto.LoginResDto;
import com.app.employeemanagement.dto.RoleDto;
import com.app.employeemanagement.dto.TokenDto;
import com.app.employeemanagement.model.Employee;
import com.app.employeemanagement.model.Login;
import com.app.employeemanagement.service.EmployeeService;
import com.app.employeemanagement.service.JwtTokenService;
import com.app.employeemanagement.service.LoginService;

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
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenUtil;
    
    @Autowired
    EmployeeService userService;
    
//    @Autowired
//    LoginService loginService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) throws AuthenticationException {
//    	LoginResDto loginResDto = new LoginResDto();
//    	Login login = new Login();
//    	login = loginService.findByEmail(loginDto.getEmail());
//    	BeanUtils.copyProperties(user, loginResDto, "password");
//    	RoleDto role = new RoleDto();
//    	role.setRoleName(user.getRole().getRoleName());
//    	loginResDto.setRole(role);
//        final Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginUser.getEmail(),
//                        loginUser.getPassword()
//                )
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        final String token = jwtTokenUtil.generateToken(authentication);
//        TokenDto authToken = new TokenDto(token);
//        loginResDto.setToken(authToken.getToken());
        return ResponseEntity.ok("ok");
    }

}
