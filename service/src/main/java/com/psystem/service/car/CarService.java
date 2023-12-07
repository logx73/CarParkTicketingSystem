package com.psystem.service.car;

import com.psystem.model.car.Car;
import com.psystem.repository.car.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public List<String> getCarsByColour(String colour) {
        return carRepository.findAllByColour(colour).stream().map(Car::getRegistrationNumber).toList();
    }
}
