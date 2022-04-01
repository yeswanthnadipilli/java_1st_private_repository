package com.simplegenericapi.service;


import com.simplegenericapi.dto.QueryRequest;
import com.simplegenericapi.repository.DbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService{

    @Autowired
    private DbRepository repository;

    @Override
    public Object createUsers(QueryRequest request) {
        repository.saveUser(request);
        return request.getParams();
    }

    @Override
    public Object updateUser(QueryRequest request) {
        repository.updateUser(request);
        return request.getParams();
    }

    @Override
    public Object deleteUser(QueryRequest request) {
        repository.deleteById(request);
        return request.getParams();
    }

    @Override
    public List allUsers(QueryRequest res) {
        List users = repository.findAll(res);
        return users;
    }

    @Override
    public Object searchParticularUser(QueryRequest res) {
        Object user = repository.findByParticularData(res);
        return user;
    }

}
