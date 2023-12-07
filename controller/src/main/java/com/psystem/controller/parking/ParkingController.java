package com.psystem.controller.parking;

import com.psystem.global.Exception.InvalidCharacterException;
import com.psystem.model.parking.ParkingLot;
import com.psystem.service.parking.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.psystem.global.GlobalVariables.REGEX_TO_ONLY_ALLOW_ALPHABETS;
import static com.psystem.global.GlobalVariables.REGEX_TO_ONLY_ALLOW_INTEGER;

@RestController
public class ParkingController {
    @Autowired
    private ParkingService parkingService;

    @PostMapping("/v1/parking-management/parking/{parkingCapacity}")
    ResponseEntity<String> createParkingLot(@PathVariable Integer parkingCapacity){
        if(parkingCapacity.toString().matches(REGEX_TO_ONLY_ALLOW_INTEGER)){
            return ResponseEntity.ok(parkingService.createParking(parkingCapacity));
        }
        throw new InvalidCharacterException();
    }
}
