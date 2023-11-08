package com.psystem.controller.car;

import com.psystem.model.car.Car;
import com.psystem.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/v1/parking-management/cars")
    ResponseEntity<List<Car>> getAllCars(){
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping(value = "/v1/parking-management/cars/{colour}")
    ResponseEntity<List<Car>> getCarByColour(@PathVariable String colour){
        if(colour.matches()){

        }
        return ResponseEntity.ok(carService.getCarsByColour(colour));
    }

}
