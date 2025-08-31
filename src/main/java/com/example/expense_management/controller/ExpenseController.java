package com.example.expense_management.controller;

import com.example.expense_management.dto.ExpenseDTO;
import com.example.expense_management.model.Employee;
import com.example.expense_management.model.Expense;
import com.example.expense_management.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService=expenseService;
    }
    @GetMapping
    public List<Expense> getAllExpenses(){
        return expenseService.getAllExpenses();
    }
    @PostMapping
    public Expense createExpense(@RequestBody Expense expense){
        return expenseService.createExpense(expense);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id){
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }
    @GetMapping("/title/{title}")
    public ResponseEntity<Expense> getExpenseByTitle(@PathVariable String title){
        return ResponseEntity.ok(expenseService.getExpenseByTitle(title));
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<Expense> getExpenseByCategory(@PathVariable String category){
        return  ResponseEntity.ok(expenseService.getExpenseByCategory(category));
    }
    @GetMapping("/date/{date}")
    public ResponseEntity<Expense> getExpenseByDate(@PathVariable LocalDate date){
        return ResponseEntity.ok(expenseService.getExpenseByDate(date));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense Deleted Successfully");
    }
}
