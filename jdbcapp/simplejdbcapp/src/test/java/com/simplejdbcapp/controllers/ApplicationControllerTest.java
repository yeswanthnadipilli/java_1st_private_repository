package com.simplejdbcapp.controllers;






import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplejdbcapp.controller.UserController;
import com.simplejdbcapp.domain.User;
import com.simplejdbcapp.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@WebMvcTest(UserController.class)
class ApplicationControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService service;

    @DisplayName("ADD USER CONTROLLER TESTING")
    @Test
    void addUser() throws Exception {

        User user = new User();
        user.setId(125);
        user.setName("Vasanth");
        user.setEmail("vas@gmail.com");
        user.setCity("mumbai");
        ObjectMapper mapper = new ObjectMapper();

        Mockito.when(service.createUser(user)).thenReturn(user);
        mvc.perform(MockMvcRequestBuilders.post("/api/create-users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @DisplayName("UPDATE USER CONTROLLER TESTING")
    @Test
    void updateUser() throws Exception {
        User user = new User();
        user.setId(125);
        user.setName("Vasanth");
        user.setEmail("vas@gmail.com");
        ObjectMapper mapper = new ObjectMapper();

        Mockito.when(service.updateUser(user)).thenReturn(user);
        mvc.perform(MockMvcRequestBuilders.put("/api/update-users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @DisplayName("DELETE USER CONTROLLER TESTING")
    @Test
    void deleteUser() throws Exception {
        int id = 125;
        String uri = "/api/delete-user/" + id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
    }

    @DisplayName("SEARCH USER CONTROLLER TESTING")
    @Test
    void searchUsers() throws Exception {
        User user1 = new User();
        user1.setId(125);
        user1.setName("Vasanth");
        user1.setEmail("vas@gmail.com");
        user1.setCity("bangalore");

        User user2 = new User();
        user2.setId(126);
        user2.setName("Rohit");
        user2.setEmail("rohit@gmail.com");
        user2.setCity("delhi");

        Mockito.when(service.allUsers()).thenReturn(List.of(user1, user2));
        mvc.perform(MockMvcRequestBuilders.get("/api/get-users"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @DisplayName("SEARCH PARTICULAR USER CONTROLLER TESTING")
    @Test
    void searchUsersById() throws Exception {
        User user1 = new User();
        user1.setId(125);
        user1.setName("Vasanth");
        user1.setEmail("vas@gmail.com");
        user1.setCity("chennai");

        int searchId = 125;
        Mockito.when(service.searchParticularUser(searchId)).thenReturn(user1);
        mvc.perform(MockMvcRequestBuilders.get("/api/search/" + searchId))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}