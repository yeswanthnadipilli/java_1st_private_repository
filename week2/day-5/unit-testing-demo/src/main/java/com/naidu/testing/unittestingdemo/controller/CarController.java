package com.naidu.testing.unittestingdemo.controller;


import com.naidu.testing.unittestingdemo.domine.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;


@RequestMapping("/car")
@RestController
public class CarController {


    @GetMapping
    public ResponseEntity<Car> getCar() {
        var car = new Car();
        car.setCost(56.23);
        car.setId(10L);
        car.setModel("abc");
        car.setMfg(Date.valueOf(LocalDate.now()));
        return ResponseEntity.ok(car);
    }

    @PostMapping
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }
}
