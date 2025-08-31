package com.example.expense_management.controller;

import com.example.expense_management.model.Employee;
import com.example.expense_management.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee addEmployee(Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestParam String username, @RequestParam String email) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, username, email));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@RequestBody Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted succesfully!");
    }
    @GetMapping("/email")
    public ResponseEntity<Employee> getEmployeeByEmail(@RequestParam String email) {
        return ResponseEntity.ok(employeeService.getEmployeeByEmail(email));
}
}













