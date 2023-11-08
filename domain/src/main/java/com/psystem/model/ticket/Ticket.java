package com.psystem.model.ticket;

import com.psystem.model.car.Car;
import com.psystem.model.parking.ParkingLot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Ticket {
    @Id
    private Long ticketId;
    @OneToOne(cascade = CascadeType.ALL)
    private Car car;
    @OneToOne
    @JoinColumn(name = "parkingLot_Id", referencedColumnName = "parking_Id")
    private ParkingLot parkingLot;
}
