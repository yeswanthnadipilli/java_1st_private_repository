package com.simplejdbcapp.repository;


import com.simplejdbcapp.domain.User;
import com.simplejdbcapp.dto.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DbRepository {

    @Autowired
    private JdbcTemplate template;

    public User findById(int id, QueryResponse res){
        User user = template.queryForObject(res.getSearchQuery(),
                new BeanPropertyRowMapper<>(User.class),
                id);
        return user;
    }


//    public User getByID(QueryResponse res) {
//        String param = res.getQuery() + res.getParam();
//        System.out.println(param);
//        User user = (User) jdbcTemplate.queryForObject(param,
//                new BeanPropertyRowMapper<>(User.class));
//
//        return user;

    public List<User> findAll(QueryResponse res){
        List<User> user = template.query(res.getSearchQuery(),
                new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    public int deleteById(int id, QueryResponse res) {
        return template.update(res.getSearchQuery(),id);
    }

    public User saveUser( QueryResponse res,User user){

        template.update(res.getSearchQuery(),
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCity());
        return user;
    }

}