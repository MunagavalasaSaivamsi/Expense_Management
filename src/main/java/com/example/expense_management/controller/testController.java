package com.example.expense_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class testController {

    @GetMapping("/test")
    public Map<String, Object> getTest() {
        Map<String, Object> data = new HashMap<>();
        data.put("message", "Hello, Vicky!");
        data.put("status", "success");
        return data;
    }
}
