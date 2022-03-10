package com.simplejdbcapp.service;

import com.simplejdbcapp.domain.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User updateUser(User user);

    String deleteUser(int id);

    List<User> allUsers();

    public User searchParticularUser(int id);


}