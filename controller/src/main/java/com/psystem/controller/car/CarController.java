package com.psystem.controller.car;

import com.psystem.global.Exception.InvalidCharacterException;
import com.psystem.model.car.Car;
import com.psystem.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.psystem.global.GlobalVariables.REGEX_TO_ONLY_ALLOW_ALPHABETS;

@RestController
public class CarController {

    @Autowired
    private CarService carService;
    @GetMapping(value = "/v1/parking-management/cars")
    ResponseEntity<List<Car>> getAllCars(){
        return ResponseEntity.ok(carService.getAllCars());
    }
    @GetMapping(value = "/v1/parking-management/cars/{colour}")
    ResponseEntity<List<String>> getCarByColour(@PathVariable String colour){
            if(colour.matches(REGEX_TO_ONLY_ALLOW_ALPHABETS)){
                return ResponseEntity.ok(carService.getCarsByColour(colour));
            }
            throw new InvalidCharacterException();
    }
}
