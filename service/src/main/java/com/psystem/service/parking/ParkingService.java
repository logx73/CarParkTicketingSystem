package com.psystem.service.parking;

import com.psystem.model.parking.ParkingLot;
import com.psystem.repository.parking.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;
    public String createParking(Integer parkingCapacity) {
            ParkingLot parkingLot = new ParkingLot();
            parkingLot.setParkingCapacity(parkingCapacity);
            parkingLot.setRemainingCapacity(parkingCapacity);
        return parkingRepository.save(parkingLot).equals(parkingLot)?"Parking Lot Created":"Parking Lot Not Created";
    }

    public List<ParkingLot> getAllParkingLot() {
        return parkingRepository.findAll();
    }
}
