package com.simplejdbcapp.controller;

import com.simplejdbcapp.domain.User;
import com.simplejdbcapp.dto.ResponseApi;
import com.simplejdbcapp.exception.*;
import com.simplejdbcapp.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService service;

    private static final String SUCCESS = "PROCESSED SUCCESS";
    private static final String FAILED = "PROCESSED FAILED";


    @PostMapping("/user")
    @ApiOperation("To add the User info")
    @ApiResponses({@ApiResponse( code = 200 , message = "User Saved"),
            @ApiResponse(code = 404, message = "Class not found"),
            @ApiResponse(code = 500, message = "Internal Server error")})
    public ResponseEntity<ResponseApi<User>> saveUser(@RequestBody User user) {
        try {
            var response = new ResponseApi<User>();
            response.setStatus(SUCCESS);
            response.setBody(service.createUser(user));
            response.setMessage("data has created");
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch(FieldCannotEmptyException | InvalidIdInputException | UserIdAlreadyTakenException e) {
            var response = new ResponseApi<User>();
            response.setStatus(FAILED);
            response.setBody(user);
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
           return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }



    @PutMapping("/update-user")
    @ApiOperation("To update the User info")
    @ApiResponses({@ApiResponse( code = 200 , message = "User updated"),
            @ApiResponse(code = 404, message = "Class not found"),
            @ApiResponse(code = 500, message = "Internal Server error")})
    public ResponseEntity<ResponseApi<User>> updateUsersData(@RequestBody User user) {
        try {
            var response = new ResponseApi<User>();
            response.setStatus(SUCCESS);
            response.setBody(service.updateUser(user));
            response.setMessage("Data Has Been Updated");
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (InvalidIdInputException | DataNotFoundException | FieldCannotEmptyException e) {
            var response = new ResponseApi<User>();
            response.setStatus(FAILED);
            response.setBody(user);
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/delete-user/{id}")
    @ApiOperation("To delete the User")
    @ApiResponses({@ApiResponse( code = 200 , message = "User deleted"),
            @ApiResponse(code = 404, message = "Class not found"),
            @ApiResponse(code = 500, message = "Internal Server error")})
    public ResponseEntity<ResponseApi<String>> deleteUser(@PathVariable int id) {
        try {
            var response = new ResponseApi<String>();
            response.setStatus(SUCCESS);
            response.setBody(service.deleteUser(id));
            response.setMessage("Data Has Been Deleted Using Primary Key : "+id);
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (UserIdNotFoundException e) {
            var response = new ResponseApi<>();
            response.setStatus(FAILED);
            response.setBody("ERROR OCCURRED WITH ENTERED ID : " + id);
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-users")
    @ApiOperation("To get the User info")
    @ApiResponses({@ApiResponse( code = 200 , message = "User info"),
            @ApiResponse(code = 404, message = "Class not found"),
            @ApiResponse(code = 500, message = "Internal Server error")})
    public ResponseEntity<ResponseApi<List<User>>> searchUsers() {
        try {
            var response = new ResponseApi<List<User>>();
            response.setStatus(SUCCESS);
            response.setBody(service.allUsers());
            response.setMessage("Users Has Been Searched SuccessFully !");
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (NoRecordsException e) {
            var response = new ResponseApi<>();
            response.setStatus(FAILED);
            response.setBody("list empty-");
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/search/{id}")
    @ApiOperation("To get the Particular User info")
    @ApiResponses({@ApiResponse( code = 200 , message = "User info"),
            @ApiResponse(code = 404, message = "Class not found"),
            @ApiResponse(code = 500, message = "Internal Server error")})
    public ResponseEntity<ResponseApi<User>> searchUsersById(@PathVariable int id) {
        try {
            var response = new ResponseApi<User>();
            response.setStatus(SUCCESS);
            response.setBody(service.searchParticularUser(id));
            response.setMessage("Users Has Been Searched SuccessFully By Primary Key ID : "+id);
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (SearchUserNotPresentException e) {
            var response = new ResponseApi<>();
            response.setStatus(FAILED);
            response.setBody("Enter Data Properly !");
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }
}
