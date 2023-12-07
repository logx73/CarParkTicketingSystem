package com.psystem.global.Exception;

public class ParkingSpaceException extends RuntimeException{
    public ParkingSpaceException(){
        super("Parking Space is Full");
    }
}
