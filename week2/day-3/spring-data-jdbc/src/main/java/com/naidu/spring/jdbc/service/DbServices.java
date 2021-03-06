package com.naidu.spring.jdbc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class DbServices {


    @Autowired
    private JdbcTemplate template;

    public void saveOperation(int empId, String empName, String dob, boolean isManager) {
        template.update(con -> {
            var sql = "insert into emp_info values (?, ?, ? ,? )";

            var ps = con.prepareStatement(sql);
            ps.setInt(1, empId);
            ps.setString(2, empName);
            ps.setDate(3, Date.valueOf(dob));
            ps.setBoolean(4, isManager);
            return ps;
        });
    }

    public void selectCars() {

    }


}
