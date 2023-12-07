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

    private List<ParkingLot> getAllParkingLot() {
        return parkingRepository.findAll();
    }

    public ParkingLot checkIfParkingAvilable(){
        int no_of_parkingLot = getAllParkingLot().size();
        for(int i=0;i<no_of_parkingLot;i++){
            if(getAllParkingLot().get(i).getRemainingCapacity()>0){
                ParkingLot parkingLot = getAllParkingLot().get(i);
                parkingLot.setRemainingCapacity(parkingLot.getRemainingCapacity()-1);
                parkingRepository.save(parkingLot);
                return getAllParkingLot().get(i);
            }
        }
        return null;
    }
}
