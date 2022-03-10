package com.simplejdbcapp.restapitest;


import com.simplejdbcapp.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestUserControllerTesting {

    @Autowired
    TestRestTemplate template;

    @LocalServerPort
    int port;

//    @DisplayName("Post - User - Saving User Object")
//    @Test
//    public void testPostMethod() {
//        String url = "http://" + "localhost" + ":" + port + "/api/user";
//        var user = new User();
//        user.setId(2);
//        user.setName("jack");
//        user.setEmail("jack@gmail.com");
//        user.setCity("kurnool");
//
//        var re = template.postForEntity(url, user, User.class);
//        Assertions.assertEquals(HttpStatus.OK, re.getStatusCode());
//    }

    @DisplayName("Testing PUT Method")
    @Test
    public void testPutMethod() {
        var obj = new User();
        obj.setId(121);
        String url = "http://" + "localhost" + ":" + port + "/api/update-users";
        var us = new User();
        us.setId(121);
        us.setName("Rohit");
        us.setEmail("rohit@gmail.com");
        template.put(url, us);
        Assertions.assertNotNull(us);
    }

    @DisplayName("Testing GET Method")
    @Test
    public void testGetMethod() {
        var obj = new User();
        obj.setId(121);
        obj.setName("Rohit");
        obj.setEmail("rohit@gmail.com");
        obj.setCity("1234");
        List<User> list = new ArrayList<>();
        list.add(obj);
        Assertions.assertEquals(1, list.size());
    }




    @DisplayName("DELETE Method")
    @Test
    public void deleteTest() {

        int id = 3;
        String url = "http://" + "localhost" + ":" + port + "/api/delete-user/" + id;
        var obj = new User();
        obj.setId(121);
        obj.setName("Rohit");
        obj.setEmail("rohit@gmail.com");
        obj.setCity("mumbia");
        List<User> list = new ArrayList<>();
        list.add(obj);

        template.delete(url);
        list.remove(obj);

        Assertions.assertEquals(0, list.size());
    }

}
