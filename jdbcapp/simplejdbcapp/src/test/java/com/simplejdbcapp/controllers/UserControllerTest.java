//package com.simplejdbcapp.controllers;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.simplejdbcapp.domain.User;
//import io.swagger.models.Response;
//import jdk.jfr.Description;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserControllerTest {
//    private MockMvc mockMvc;
//    @Autowired
//    private WebApplicationContext context;
//
//    ObjectMapper mapper = new ObjectMapper();
//
//    @Before
//    public void setUp() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }
//
//    @Test
//    @Description("Test for PostMethod")
//    public void addUser() throws Exception {
//        User user = new User();
//        user.setId(8);
//        user.setName("rohit");
//        user.setEmail("rohit@gmail.com");
//        user.setCity("mumbai");
//        String JsonRequest = mapper.writeValueAsString(user);
//        MvcResult result = mockMvc.perform(post("/user").content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk()).andReturn();
//        String resultContext = result.getResponse().getContentAsString();
//
//        Response response = mapper.readValue(resultContext, Response.class);
//
//        Assert.assertEquals(user, user);
//    }
//
//    @Test
//    @Description("Testing for PutMethod")
//    public void User() throws Exception {
//        User user = new User();
//        user.setId(1);
//        user.setName("rohit");
//        user.setEmail("rohit@gmail.com");
//        String JsonRequest = mapper.writeValueAsString(user);
//        MvcResult result = mockMvc.perform(put("/update-user").content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk()).andReturn();
//        String resultContext = result.getResponse().getContentAsString();
//
//        Response response = mapper.readValue(resultContext, Response.class);
//
//        Assert.assertEquals(user, user);
//    }
//
//
//}
