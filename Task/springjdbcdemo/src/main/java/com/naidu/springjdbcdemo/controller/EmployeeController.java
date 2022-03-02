package com.naidu.springjdbcdemo.controller;


import com.naidu.springjdbcdemo.dao.EmployeeDAO;
import com.naidu.springjdbcdemo.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeDAO eDAO;


    @GetMapping("/employees")
    public List<Employee> getEmployee() {
       return eDAO.getAll();
    }


    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return eDAO.getById(id);
    }

    @PostMapping("/employees")
    public  String saveEmployee(@RequestBody Employee employee) {
        return eDAO.save(employee) + "No of rows saved to the database";
    }


    @PutMapping("/employees/{id}")
    public String updateEmployee(@RequestBody Employee employee,@PathVariable int id) {
        return eDAO.update(employee, id) + " No of rows update to the database";
    }


    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable int id) {
       return eDAO.delete(id) + " no of rows deleted in database";
    }
}
