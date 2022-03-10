package com.simplejdbcapp.service;

import com.simplejdbcapp.domain.User;
import com.simplejdbcapp.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private JdbcTemplate jdbctemplate;

    private static final String INSERT_USER_QUERY = "insert into User(id,name,email,city) values(?,?,?,?)";
    private static final String UPDATE_USER_QUERY = "update User SET name=?,email=? where id=?";
    private static final String DELETE_USER_QUERY = "delete from User where id=?";
    private static final String GET_USERS_QUERY = "select * from User";
    private static final String GET_USERS_BY_ID_QUERY = "select * from User where id=?";

    @Override
    public User createUser(User user) {
        if (user.getId() <= 0)
            throw new InvalidIdInputException("Please Enter Valid ID !");

        if (user.getName() == null  || user.getEmail() == null || user.getCity() == null)
            throw new FieldCannotEmptyException("Please Enter Proper Data ");

        List<User> lists = jdbctemplate.query(GET_USERS_QUERY, (rs, rowNum) ->
                new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("city"))
        );

        var users = lists.stream().anyMatch(user1 -> user1.getId() == user.getId());
        if (users)
            throw new UserIdAlreadyTakenException(" Entered User ID Has Been Already Registered !");
        else {
            jdbctemplate.update(INSERT_USER_QUERY,
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getCity()
            );
            return user;
        }
    }



    @Override
    public User updateUser(User user) {
        if (user.getId() <= 0)
            throw new InvalidIdInputException("Please Enter Valid ID !");

        if (user.getName() == null || user.getEmail() == null)
            throw new FieldCannotEmptyException("Please Enter Proper Data ");

        List<User> lists = jdbctemplate.query(GET_USERS_QUERY, (rs, rowNum) ->
                new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("city"))
        );
        var users = lists.stream().anyMatch(user1 -> user1.getId() == user.getId());
        if (users) {

            jdbctemplate.update(UPDATE_USER_QUERY,

                    user.getName(),
                    user.getEmail(),
                    user.getId()
            );
            return user;
        } else
            throw new DataNotFoundException("Entered Data is Not Found at the Database ");

    }






        public String deleteUser(int id) {

            List<User> lists = jdbctemplate.query(GET_USERS_QUERY, (rs, rowNum) ->
                    new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("city")));
            var users = lists.stream().anyMatch(user -> user.getId() == id);

            if (users) {
                jdbctemplate.update(DELETE_USER_QUERY, id);
                return "User Has Been Deleted By Given ID : " + id;
            } else
                throw new UserIdNotFoundException("Entered Id is Not Present Kindly check");
        }

        public List<User> allUsers() {
            List<User> users = jdbctemplate.query(GET_USERS_QUERY, (rs, rowNum) ->
                    new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("city"))
            );
            if (users.isEmpty())
                throw new NoRecordsException("Records Has Been Empty !!");
            return users;
        }


    public User searchParticularUser(int id) {

        List<User> lists = jdbctemplate.query(GET_USERS_QUERY, (rs, rowNum) ->
                new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("city"))
        );
        var user1 = lists.stream().anyMatch(user -> user.getId() == id);

        if (user1) {
            var users = jdbctemplate.queryForObject(GET_USERS_BY_ID_QUERY, (rs, rowNum) ->
                    new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("city")), id
            );
            return users;
        } else
            throw new SearchUserNotPresentException("Oops ! Please Enter Correct User ID !!! ");

    }

}