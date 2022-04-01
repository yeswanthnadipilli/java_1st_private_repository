package com.simplegenericapi.controllers;


import com.simplegenericapi.dto.QueryRequest;
import com.simplegenericapi.dto.ResponseApi;
import com.simplegenericapi.service.ApiService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/database")
public class ApplicationController {

    @Autowired
    private ApiService service;

    private static final String SUCCESS = "PROCESSED SUCCESS";
    private static final String FAILED = "PROCESSED FAILED";

    @PostMapping(value = "/create-users")
    @ApiOperation("To add the User info")
    @ApiResponses({@ApiResponse( code = 200 , message = "User Saved"),
            @ApiResponse(code = 404, message = "Class not found"),
            @ApiResponse(code = 500, message = "Internal Server error")})
    public ResponseEntity<ResponseApi> addUser(@RequestBody QueryRequest request) {
        try {
            var response = new ResponseApi();
            response.setStatus(SUCCESS);
            response.setBody(service.createUsers(request));
            response.setMessage("Data Has Been Created  ");
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            var response = new ResponseApi();
            response.setStatus(FAILED);
            response.setBody(request);
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/update-users")
    @ApiOperation("To update the User info")
    @ApiResponses({@ApiResponse( code = 200 , message = "User updated"),
            @ApiResponse(code = 404, message = "Class not found"),
            @ApiResponse(code = 500, message = "Internal Server error")})
    public ResponseEntity<ResponseApi> updateUsersData(@RequestBody QueryRequest request) {
        try {
            var response = new ResponseApi();
            response.setStatus(SUCCESS);
            response.setBody(service.updateUser(request));
            response.setMessage("Data Has Been Updated...");
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            var response = new ResponseApi<>();
            response.setStatus(FAILED);
            response.setBody(request);
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/delete-user")
    @ApiOperation("To delete the User")
    @ApiResponses({@ApiResponse( code = 200 , message = "User deleted"),
            @ApiResponse(code = 404, message = "Class not found"),
            @ApiResponse(code = 500, message = "Internal Server error")})
    public ResponseEntity<ResponseApi> deleteUser(@RequestBody QueryRequest request) {
        try {
            var response = new ResponseApi();
            response.setStatus(SUCCESS);
            response.setBody(service.deleteUser(request));
            response.setMessage("Data Has Been Deleted... ");
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            var response = new ResponseApi<>();
            response.setStatus(FAILED);
            response.setBody("ERROR OCCURRED ...");
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/get-users")
    @ApiOperation("To get the User info")
    @ApiResponses({@ApiResponse( code = 200 , message = "User info"),
            @ApiResponse(code = 404, message = "Class not found"),
            @ApiResponse(code = 500, message = "Internal Server error")})
    public ResponseEntity<ResponseApi<List<Object>>> searchUsers(@RequestBody QueryRequest user) {
        try {
            var response = new ResponseApi<List<Object>>();
            response.setStatus(SUCCESS);
            response.setBody(service.allUsers(user));
            response.setMessage("Data Has Been Searched SuccessFully !");
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            var response = new ResponseApi<>();
            response.setStatus(FAILED);
            response.setBody("LIST EMPTY !");
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(value = "/get-user")
    @ApiOperation("To get the Particular User info")
    @ApiResponses({@ApiResponse( code = 200 , message = "User info"),
            @ApiResponse(code = 404, message = "Class not found"),
            @ApiResponse(code = 500, message = "Internal Server error")})
    public ResponseEntity<ResponseApi> searchUsersById(@RequestBody QueryRequest user) {
        try {
            var response = new ResponseApi<>();
            response.setStatus(SUCCESS);
            response.setBody(service.searchParticularUser(user));
            response.setMessage("Data Has Been Searched SuccessFully");
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
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
