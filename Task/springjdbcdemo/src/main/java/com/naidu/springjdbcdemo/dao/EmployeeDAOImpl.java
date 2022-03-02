package com.naidu.springjdbcdemo.dao;


import com.naidu.springjdbcdemo.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update("insert into tbl_employee(id, name, email, department) VALUES(?,?,?,?)",
                new Object[] {employee.getId(),employee.getName(), employee.getEmail(), employee.getDepartment()});
    }

    @Override
    public int update(Employee employee, int id) {
       return jdbcTemplate.update("UPDATE tbl_employee SET name=?, email=?, department=? WHERE id =?",
               new Object[] {employee.getName(), employee.getEmail(), employee.getDepartment()}, id);
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from tbl_employee where id=?", id);
    }

    @Override
    public List<Employee> getAll() {
        return jdbcTemplate.query("SELECT * FROM tbl_employee",new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    @Override
    public Employee getById(int id) {
       return jdbcTemplate.queryForObject("select * from tbl_employee where id = ? ",new BeanPropertyRowMapper<Employee>(Employee.class), id);
    }
}
