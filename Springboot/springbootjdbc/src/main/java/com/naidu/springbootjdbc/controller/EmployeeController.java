package com.naidu.springbootjdbc.controller;


import com.naidu.springbootjdbc.domain.Employee;
import com.naidu.springbootjdbc.dto.ResponceApi;
import com.naidu.springbootjdbc.exception.UserIdNotFoundException;
import com.naidu.springbootjdbc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmpService emps;


    @PostMapping("/employees")
    public ResponseEntity<ResponceApi<Employee>> saveEmployee(@RequestBody Employee employee) {
        try {
            var response = new ResponceApi<Employee>();
            response.setStatus("SUCCESS");
            response.setBody(emps.save(employee));
            response.setMessage("data has created");
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            var response = new ResponceApi<Employee>();
            response.setStatus("FAILED");
            response.setBody(employee);
            response.setMessage(" Error Occurred");
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/employees/{id}")
    public ResponseEntity<ResponceApi<Employee>> updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
        try {
            var response = new ResponceApi<Employee>();
            response.setStatus("SUCCESS");
            response.setBody(emps.update(employee, id));
            response.setMessage("data has been updated");
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            var response = new ResponceApi<Employee>();
            response.setStatus("FAILED");
            response.setBody(employee);
            response.setMessage("Error Occurred");
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/employees")
    public ResponseEntity<ResponceApi<List<Employee>>> getEmployees() {
        try {
            var response = new ResponceApi<List<Employee>>();
            response.setStatus("SUCCESS");
            response.setBody(emps.getAll());
            response.setMessage("Employee searched successfully");
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            var response = new ResponceApi<>();
            response.setStatus("FAILED");
            response.setBody("DATA ENTERED IS NOT CORRECT");
            response.setMessage("Error Occurred");
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }

    }



    @DeleteMapping("employees/{id}")
    public ResponseEntity<ResponceApi<String>> deleteUser(@PathVariable int id) {
        try {
            var response = new ResponceApi<String>();
            response.setStatus("SUCCESS");
            response.setBody(emps.deleteEmployee(id));
            response.setMessage("Data Has Been Deleted ! ");
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (UserIdNotFoundException e) {
            var response = new ResponceApi<>();
            response.setStatus("FAILED");
            response.setBody("ERROR OCCURRED WITH ENTERED ID : " + id);
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }
}