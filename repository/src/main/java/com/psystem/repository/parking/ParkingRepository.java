package com.psystem.repository.parking;

import com.psystem.model.parking.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingRepository extends JpaRepository<ParkingLot,Long> {
    List<ParkingLot> findAll();
}
