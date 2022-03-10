package com.simplejdbcapp.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @DisplayName("Domain : Checking getters and setters Method")
    @Test
    void testObjectGettersSetters() {
        var user1 = new User();
        user1.setId(1);
        user1.setName("chandu");
        user1.setEmail("chandu@gmail.com");
        user1.setCity("hyd");
        Assertions.assertEquals(1, user1.getId());
        Assertions.assertEquals("chandu", user1.getName());
        Assertions.assertEquals("chandu@gmail.com", user1.getEmail());
        Assertions.assertEquals("hyd",user1.getCity());
    }

    @DisplayName("Testing Object Nullability")
    @Test
    void testInValidObject() {
        User user = null;
        Assertions.assertNull(user);
    }

    @DisplayName("User Valid Object")
    @Test
    void testValidObject() {
        User user = new User();
        Assertions.assertNotNull(user);
    }
}
