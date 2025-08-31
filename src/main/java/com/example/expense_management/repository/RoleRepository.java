package com.example.expense_management.repository;

import com.example.expense_management.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

Optional<Role> findByName(String name);
}

