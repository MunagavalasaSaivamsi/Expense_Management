package com.example.expense_management.repository;

import com.example.expense_management.model.Expense;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    Optional<Expense> findByTitleIgnoreCase(String title);

    Optional<Expense> findByDate(LocalDate date);

    Optional<Expense> findByCategoryIgnoreCase(String category);

}
