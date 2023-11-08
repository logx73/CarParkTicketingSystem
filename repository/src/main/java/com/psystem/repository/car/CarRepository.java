package com.psystem.repository.car;

import com.psystem.model.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> {
    List<Car> findAllByColour(String colour);
}
