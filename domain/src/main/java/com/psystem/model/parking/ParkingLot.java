package com.psystem.model.parking;

import javax.persistence.*;

@Entity
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parking_Id;
    private int parkingCapacity;
    private int remainingCapacity;

    public ParkingLot(Long parking_Id, int parkingCapacity, int remainingCapacity) {
        this.parking_Id = parking_Id;
        this.parkingCapacity = parkingCapacity;
        this.remainingCapacity = remainingCapacity;
    }

    public ParkingLot() {
    }

    public Long getParking_Id() {
        return parking_Id;
    }

    public void setParking_Id(Long parking_Id) {
        this.parking_Id = parking_Id;
    }

    public int getParkingCapacity() {
        return parkingCapacity;
    }

    public void setParkingCapacity(int parkingCapacity) {
        this.parkingCapacity = parkingCapacity;
    }

    public int getRemainingCapacity() {
        return remainingCapacity;
    }

    public void setRemainingCapacity(int remainingCapacity) {
        this.remainingCapacity = remainingCapacity;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "parkingCapacity=" + parkingCapacity +
                ", remainingCapacity=" + remainingCapacity +
                '}';
    }
}
