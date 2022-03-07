package com.naidu.springbootjdbc.service;

import com.naidu.springbootjdbc.domain.Employee;

import java.util.List;

public interface EmpService {

    Employee save(Employee emp);

    Employee update(Employee emp,int id);

    String deleteEmployee(int id);

    List<Employee> getAll();



}
