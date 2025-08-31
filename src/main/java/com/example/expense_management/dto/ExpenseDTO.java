package com.example.expense_management.dto;

import com.example.expense_management.model.Employee;

import java.time.LocalDate;
import java.util.Set;

public class ExpenseDTO {
    private Long id;
    private String title;
    private Double amount;
    private String category;
    private LocalDate date;
    private String status;

}
