package com.naidu.springjdbcdemo.dao;

import com.naidu.springjdbcdemo.domain.Employee;

import java.util.List;

public interface EmployeeDAO {

    int save(Employee employee);

    int update(Employee employee, int id);

    int delete(int id);

    List<Employee> getAll();

    Employee getById(int id);
}
