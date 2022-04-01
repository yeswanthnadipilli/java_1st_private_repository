package com.simplegenericapi.repository;

import com.simplegenericapi.dto.QueryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DbRepository {

    @Autowired
    private JdbcTemplate template;

    public Object findByParticularData(QueryRequest res) {
        String query = res.getQuery();
        Object[] myParams = res.getParams();
        int[] paramType = res.getParamType();
        System.out.println(query);
        List<Map<String, Object>> user = template.queryForList(query, myParams);
        return user;
    }

    public List findAll(QueryRequest res) {
        List user = template.queryForList(res.getQuery());
        return user;
    }

    public Object deleteById(QueryRequest request) {
        return template.update(request.getQuery(), request.getParams());
    }

    public Object saveUser(QueryRequest request) {
        return template.update(request.getQuery(), request.getParams());

    }

    public Object updateUser(QueryRequest request) {

        return template.update(request.getQuery(), request.getParams());

    }

}
