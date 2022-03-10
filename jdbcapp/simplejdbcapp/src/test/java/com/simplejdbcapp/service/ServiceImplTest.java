package com.simplejdbcapp.service;


import com.simplejdbcapp.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



@ExtendWith(SpringExtension.class)
public class ServiceImplTest {

    @MockBean
    private UserService service;

    @DisplayName("service Testing : createUsers")
    @Test
    void createUser() {
        var obj = new User();
        obj.setId(123);
        obj.setName("Prashant");
        obj.setEmail("prashant@gmail.com");
        obj.setCity("hyd");

        Mockito.when(service.createUser(obj)).thenReturn(obj);
        Assertions.assertNotNull(obj);
        Assertions.assertEquals(obj, service.createUser(obj));
    }

    @DisplayName("Service Testing :updateUser")
    @Test
    void updateUser() {
        List<User> user = new ArrayList<>();
        var obj = new User();
        obj.setId(123);
        obj.setName("Leela");
        obj.setEmail("leela@gmail.com");
        obj.setCity("bangalore");
        user.add(obj);
        int search = 123;
        boolean match = user.stream().anyMatch(user1 -> user1.getId() == search);
        if(match) {
            Mockito.when(service.updateUser(obj)).thenReturn(obj);
            obj.setId(obj.getId());
            obj.setName("Naidu");
            obj.setEmail("naidu@gmail.com");
            obj.setCity(obj.getCity());
            Assertions.assertNotNull(obj);
            Assertions.assertEquals("Naidu",obj.getName());
            Assertions.assertEquals("naidu@gmail.com",obj.getEmail());
        }
    }

   @DisplayName("Service Testing : delete User")
   @Test
   void deleteUser() {
        User user = new User(123,"Yeswanth","Yeswanth@gmail.com","puna");
        service.deleteUser(user.getId());
        Mockito.verify(service, Mockito.times(1)).deleteUser(123);
   }



    @DisplayName("Servuce Testing : allUsers")
    @Test
    void allUsers() {
        Mockito.when(service.allUsers()).thenReturn(Stream.of(
                new User(101, "chandu", "chandu@gmail.com", "mumbai"),
                new User(102,"yeswanth","yeswanth@gmail.com","hyd"),
                new User(103,"leela","leela@gmail.com","bangalore"))
        .collect(Collectors.toList()));
        Assertions.assertEquals(3, service.allUsers().size());
    }

    @DisplayName("service Testing : searchParticularUser")
    @Test
    void searchParticularUser() {
        int id =150;
        Mockito.when(service.searchParticularUser(id))
                .thenReturn(
                        new User(150,"ramesh","ramesh@gail.com","chennai"));
        User user = service.searchParticularUser(id);
        Assertions.assertNotNull(user);
        Assertions.assertEquals(id,user.getId());
    }


}
