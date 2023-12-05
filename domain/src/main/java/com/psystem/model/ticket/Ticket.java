package com.psystem.model.ticket;

import com.psystem.model.car.Car;
import com.psystem.model.parking.ParkingLot;

import javax.persistence.*;


@Entity
public class Ticket {
    @Id
    private Long ticketId;
    @OneToOne(cascade = CascadeType.ALL)
    private Car car;
    @OneToOne
    @JoinColumn(name = "parkingLot_Id", referencedColumnName = "parking_Id")
    private ParkingLot parkingLot;

    public Ticket(Long ticketId, Car car, ParkingLot parkingLot) {
        this.ticketId = ticketId;
        this.car = car;
        this.parkingLot = parkingLot;
    }

    public Ticket() {
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", car=" + car +
                ", parkingLot=" + parkingLot +
                '}';
    }
}
