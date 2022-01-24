package com.naidu.spring.jdbc.controller;


import com.naidu.spring.jdbc.domain.Emp;
import com.naidu.spring.jdbc.service.DbServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/db")
@RestController
public class DbController {


    @Autowired
    private DbServices service;

    @PostMapping // POST - http://localhost:8080/db
    public String save(@RequestBody Emp emp) {
        service.saveOperation(
                emp.getId(),
                emp.getName(),
                emp.getDob(),
                emp.getManager()
        );
        return "Employee Saved";
    }







}
