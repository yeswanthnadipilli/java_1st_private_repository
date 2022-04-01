package com.simplegenericapi.service;

import com.simplegenericapi.dto.QueryRequest;

import java.util.List;

public interface ApiService {
    Object createUsers(QueryRequest request);

    Object updateUser(QueryRequest request);

    Object deleteUser(QueryRequest request);

    List<Object> allUsers(QueryRequest request);

    Object searchParticularUser(QueryRequest request);
}
