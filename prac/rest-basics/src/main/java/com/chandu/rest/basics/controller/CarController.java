package com.chandu.rest.basics.controller;


import com.chandu.rest.basics.domain.Car;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/car")
@RestController
public class CarController {


    @GetMapping("/hi")
    public String sayHi() {
        return "hi";
    }

    @GetMapping("/c")
    public Car defaultCar() {
        var car = new Car();
        car.setSpeed(100);
        car.setFwd(true);
        car.setParts(List.of("abc","pqr","lmn"));

        return car;
    }

    @PostMapping
    public Car saveCar(@RequestBody Car car) {
        var cr = new Car();
        cr.setSpeed(1);
        cr.setFwd(false);
        cr.setParts(car.getParts());
        return cr;
    }

    @PutMapping
    public Car updateCar(@RequestBody Car updatedCar) {
        return updatedCar;

    }


    @DeleteMapping("/{carId}")
    public String deleteCar(@PathVariable int carId) {
            return "Car deleted successdfully";


    }
}
