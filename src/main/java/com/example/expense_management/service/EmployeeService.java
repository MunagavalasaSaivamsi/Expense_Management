package com.example.expense_management.service;

import com.example.expense_management.dto.AuthDTO;
import com.example.expense_management.model.Employee;
import com.example.expense_management.repository.EmployeeRepository;
import com.example.expense_management.repository.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public EmployeeService(EmployeeRepository employeeRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Employee registerEmployee(AuthDTO authDTO) {
        Employee employee = new Employee();
        employee.setUsername(authDTO.getUsername());  // ensure Employee entity has 'username'
        employee.setEmail(authDTO.getEmail());
        employee.setPassword(passwordEncoder.encode(authDTO.getPassword()));


        return employeeRepository.save(employee);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public Employee updateEmployee(Long id, String username, String email) {
        Employee employee = getEmployeeById(id);
        employee.setUsername(username);
        employee.setEmail(email);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found with email: " + email));
    }
}
