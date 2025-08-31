package com.example.expense_management.dto;

import com.example.expense_management.model.Role;

import java.util.Set;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private Set<String> roles;
}
