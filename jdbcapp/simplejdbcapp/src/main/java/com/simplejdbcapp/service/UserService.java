package com.simplejdbcapp.service;

import com.simplejdbcapp.domain.User;
import com.simplejdbcapp.dto.QueryResponse;

import java.util.List;

public interface UserService {

    User createUsers(User user,QueryResponse res);


    User updateUser(User user);


    String deleteUser(int id,QueryResponse user);


    List<User> allUsers(QueryResponse res);


    User searchParticularUser(int id,QueryResponse res);

}