package com.naidu.testing.unittestingdemo.controller;

import com.naidu.testing.unittestingdemo.domine.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarControllerTest {


    @Autowired
    private TestRestTemplate template; // it is wrapper over http client

    @LocalServerPort
    private int port;

    @DisplayName("GET - Car - Checking Object is non null")
    @Test
    public void testGetMethod() {

        String url = "http://" + "localhost" +":" + port +"/car";

        Car car = template.getForObject( // GET method
                url,
                Car.class
        );

        Assertions.assertNotNull(car);
    }

    @DisplayName("GET - Car - Checking Status Code")
    @Test
    public void testGetStatusCode() {
        String url = "http://" + "localhost" +":" + port +"/car";
        ResponseEntity<Car> entity = template.getForEntity(url, Car.class);
        Assertions.assertEquals(
                HttpStatus.OK,
                entity.getStatusCode()
        );
    }


}
