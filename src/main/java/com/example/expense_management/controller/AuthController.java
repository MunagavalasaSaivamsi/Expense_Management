package com.example.expense_management.controller;

import com.example.expense_management.dto.AuthDTO;
import com.example.expense_management.model.Employee;
import com.example.expense_management.service.EmployeeService;
import com.example.expense_management.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final EmployeeService employeeService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(EmployeeService employeeService,
                          AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.employeeService = employeeService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }
    @GetMapping("/all")
    public List<Employee> getAllUsers(@RequestBody Employee employee){
         return employeeService.getAllEmployees();
    }

    @PostMapping("/register")
    public ResponseEntity<Employee> register(@RequestBody AuthDTO authDTO) {
        Employee employee = employeeService.registerEmployee(authDTO);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthDTO authDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authDTO.getEmail(), authDTO.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtil.generateToken(authentication.getName());

        return ResponseEntity.ok(jwt);
    }




}


