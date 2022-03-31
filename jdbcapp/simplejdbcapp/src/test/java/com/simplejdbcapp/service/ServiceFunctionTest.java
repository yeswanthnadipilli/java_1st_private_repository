//package com.simplejdbcapp.service;
//
//
//import com.simplejdbcapp.domain.User;
//import com.simplejdbcapp.exception.*;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@ExtendWith(SpringExtension.class)
//public class ServiceFunctionTest {
//
//    @MockBean
//    private UserService service;
//
//    @DisplayName("Testing : createUserIdWithLessThanZero")
//    @Test
//    void createUserIdWithLessThanZero() {
//        var user = new User();
//        user.setId(-133);
//        user.setName("chandu");
//        user.setEmail("chandu@gamil.com");
//        user.setCity("hyd");
//        if(user.getId()<=0) {
//            Mockito.when(service.createUser(user)).thenThrow(InvalidIdInputException.class);
//            Assertions.assertThrows(InvalidIdInputException.class, () ->service.createUser(user));
//        }
//    }
//
//    @DisplayName("Testing : createUsersWithEmptyFields")
//    @Test
//    void createUsersWithEmptyFields() {
//        var user = new User();
//        user.setId(123);
//        user.setName(null);
//        user.setEmail(null);
//        user.setCity(null);
//        if (user.getName() == null || user.getEmail() == null || user.getCity() == null) {
//            Mockito.when(service.createUser(user)).thenThrow(FieldCannotEmptyException.class);
//            Assertions.assertThrows(FieldCannotEmptyException.class, () ->
//                    service.createUser(user));
//        }
//    }
//
//
//    @DisplayName("Testing : createUsersIdWithAlreadyTakenId")
//    @Test
//    void createUserIdWithAlreadyTakenId() {
//        List<User> user = new ArrayList<>();
//        var user1 = new User();
//        user1.setId(123);
//        user1.setName("chandu");
//        user1.setEmail("chandu@gmail.com");
//        user1.setCity("hyd");
//        user.add(user1);
//        var user2 = new User();
//        user2.setId(123);
//        user2.setName("naidu");
//        user2.setEmail("naidu@gmail.com");
//        user2.setCity("mumbai");
//        user.add(user2);
//        boolean match = user.stream().anyMatch(users -> user1.getId() == user2.getId());
//        if(match){
//            Mockito.when(service.createUser(user2)).thenThrow(UserIdAlreadyTakenException.class);
//            Assertions.assertThrows(UserIdAlreadyTakenException.class, () -> service.createUser(user2));
//        }
//        else
//            user.add(user2);
//    }
//
//
//    @DisplayName("Testing : updateUsersIdWIthLessThanZero")
//    @Test
//    void updateUsersIdWithLessThanZero() {
//        var user = new User();
//        user.setId(-121);
//        user.setName("chandu");
//        user.setEmail("chandu@gmail.com");
//        if (user.getId() <= 0) {
//            Mockito.when(service.updateUser(user)).thenThrow(InvalidIdInputException.class);
//            Assertions.assertThrows(InvalidIdInputException.class, () -> service.updateUser(user));
//        }
//    }
//
//
//    @DisplayName("Testing : updateUsersWithEmptyFields")
//    @Test
//    void updateUsersWithEMptyFields() {
//        var user = new User();
//        user.setId(123);
//        user.setName(null);
//        user.setEmail(null);
//        if(user.getName() ==null || user.getEmail() == null) {
//            Mockito.when(service.updateUser(user)).thenThrow(FieldCannotEmptyException.class);
//            Assertions.assertThrows(FieldCannotEmptyException.class, ()->
//                    service.updateUser(user));
//        }
//    }
//
//
//    @DisplayName("Testing : deleteUserWithValidId")
//    @Test
//    void deleteUserWithValidId() {
//        var user1 = new User();
//        user1.setId(123);
//        user1.setName("chandu");
//        user1.setEmail("chandu@gmail.com");
//        user1.setCity("mumbai");
//        int id = 123;
//        Mockito.when(service.deleteUser(id)).thenReturn("User has been deleted by given id : " + id);
//
//        Assertions.assertEquals("User has been deleted by given id : 123",service.deleteUser(id));
//    }
//
//
//
//    @DisplayName("Testing : deleteUserWithValidId")
//    @Test
//    void deleteUserWithInValidId() {
//        var user1 = new User();
//        user1.setId(123);
//        user1.setName("chandu");
//        user1.setEmail("chandu@gmail.com");
//        user1.setCity("mumbai");
//
//        int id =124;
//        Mockito.when(service.deleteUser(id)).thenThrow(UserIdNotFoundException.class);
//
//        Assertions.assertThrows(UserIdNotFoundException.class,()->service.deleteUser(id));
//    }
//
//
//
//    @DisplayName("Testing : noUserPresentInList")
//    @Test
//    void noUserPresentInList() {
//        List<User> users = new ArrayList<>();
//        if(users.isEmpty()) {
//            Mockito.when(service.allUsers()).thenThrow(NoRecordsException.class);
//            Assertions.assertThrows(NoRecordsException.class, () -> service.allUsers());
//        }
//    }
//
//    @DisplayName("Testing : userPresentsList")
//    @Test
//    void userPresentsList() {
//        List<User> users = new ArrayList<>();
//        var user1 = new User();
//        user1.setId(123);
//        user1.setName("chandu");
//        user1.setEmail("chandu@gmail.com");
//        user1.setCity("mumbai");
//        users.add(user1);
//        Mockito.when(service.allUsers()).thenReturn(users);
//        Assertions.assertSame(service.allUsers().get(0),user1);
//    }
//
//    @DisplayName("Testing : searchUserWithParticularRegisteredId")
//    @Test
//    void searchUserWithParticularRegisteredId() {
//        var user1 = new User();
//        user1.setId(1);
//        user1.setName("Chandu");
//        user1.setEmail("Chandu@gmail.com");
//        user1.setCity("mumbai");
//
//        int searchId = 1;
//        Mockito.when(service.searchParticularUser(searchId)).thenReturn(user1);
//        Assertions.assertNotNull(user1);
//        Assertions.assertSame(service.searchParticularUser(searchId),user1);
//    }
//
//    @DisplayName("Testing : searchUserWithParticularNotRegisteredId")
//    @Test
//    void searchUserWithParticularNotRegisteredId() {
//        var user1 = new User();
//        user1.setId(123);
//        user1.setName("Chandu");
//        user1.setEmail("chandu@gmail.com");
//        user1.setCity("mumbai");
//
//        List<User> lists = new ArrayList<>();
//        lists.add(user1);
//
//        int searchId = 124;
//        var userPresent = lists.stream().anyMatch(user -> user.getId() != searchId);
//        if (userPresent){
//            Mockito.when(service.searchParticularUser(searchId))
//                    .thenThrow(SearchUserNotPresentException.class);
//            Assertions.assertThrows(SearchUserNotPresentException.class,
//                    ()-> service.searchParticularUser(searchId));
//        }
//
//    }
//
//
//
//}
//
//
//
