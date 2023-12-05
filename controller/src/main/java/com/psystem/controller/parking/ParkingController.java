package com.psystem.controller.parking;

import com.psystem.model.parking.ParkingLot;
import com.psystem.service.parking.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingController {
    @Autowired
    private ParkingService parkingService;

    @PostMapping("/v1/parking-management/parking/{parkingCapacity}")
    ResponseEntity<String> createParkingLot(@PathVariable Integer parkingCapacity){
        return ResponseEntity.ok(parkingService.createParking(parkingCapacity));
    }

    @GetMapping("/v1/parking-management/parking")
    ResponseEntity<List<ParkingLot>> getAllParkingLot(){
        return ResponseEntity.ok(parkingService.getAllParkingLot());
    }
}
