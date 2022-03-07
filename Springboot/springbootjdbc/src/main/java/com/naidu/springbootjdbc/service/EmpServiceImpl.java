package com.naidu.springbootjdbc.service;

import com.naidu.springbootjdbc.domain.Employee;
import com.naidu.springbootjdbc.exception.UserIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Employee save(Employee emp) {
        jdbcTemplate.update("insert into tbl_employees(id,name,email,department) values(?,?,?,?)",
                emp.getId(),
                emp.getName(),
                emp.getEmail(),
                emp.getDepartment());
        return emp;
    }

    @Override
    public Employee update(Employee emp,int id) {
         jdbcTemplate.update("update tbl_employees SET name=?, email=? where id=?",
                 emp.getName(),
                 emp.getEmail(),
                 emp.getId()
         );
         return emp;

    }



    public String deleteEmployee(int id) {
        List<Employee> lists = jdbcTemplate.query("select * from tbl_employees",(rs, rowNum) ->
                new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("department"))
        );
        var employees = lists.stream().anyMatch(employee -> employee.getId()==id);
        if(employees) {
            jdbcTemplate.update("delete from tbl_employees where id =?",id);
            return "Employee has been deleted successfully by given di :" +id;
        }
        else
            throw new UserIdNotFoundException("Entered Id is Not Present Kindly Check ! ");
    }


    @Override
    public List<Employee> getAll() {
       return jdbcTemplate.query("select * from tbl_employees", new BeanPropertyRowMapper<Employee>(Employee.class));
    }
}
