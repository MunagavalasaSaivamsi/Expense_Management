package com.example.expense_management.service;

import com.example.expense_management.model.Expense;
import com.example.expense_management.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;



    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository=expenseRepository;

    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }
    public Expense createExpense(Expense expense){
        return expenseRepository.save(expense);
    }
    public Expense getExpenseById(Long id){
        return expenseRepository.findById(id)
                .orElseThrow(()->new RuntimeException("no expense with id:"+id));
    }
    public void deleteExpense(Long id){
        if (!expenseRepository.existsById(id)){
            throw new RuntimeException("expense not found with id:"+id);
            }
        expenseRepository.deleteById(id);
    }

    public Expense getExpenseByTitle(String title){
        return expenseRepository.findByTitleIgnoreCase(title)
                .orElseThrow(()-> new RuntimeException("Expense not found with title:"+title));
    }
    public Expense getExpenseByCategory(String category){
        return expenseRepository.findByCategoryIgnoreCase(category)
                .orElseThrow(()->new RuntimeException("Expense not found with this category:"+category));
    }
    public Expense getExpenseByDate(LocalDate date){
        return expenseRepository.findByDate(date)
                .orElseThrow(()->new RuntimeException("Expense not found with the Date:"+date));
    }


}
