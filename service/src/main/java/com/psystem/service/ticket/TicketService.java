package com.psystem.service.ticket;

import com.psystem.model.parking.ParkingLot;
import com.psystem.global.Exception.ParkingSpaceException;
import com.psystem.model.ticket.Ticket;
import com.psystem.repository.ticket.TicketRepository;
import com.psystem.service.parking.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ParkingService parkingService;

    @Transactional
    public Ticket saveTicket(Ticket ticket){
            ParkingLot parkingLot = parkingService.checkIfParkingAvilable();
            if(parkingLot==null){
                throw new ParkingSpaceException();
            }
            else {
                ticket.setParkingLot(parkingLot);
            }
            return ticketRepository.save(ticket);
    }

    public Long getTicketByRegistrationNumber(String registrationNumber) {
        return ticketRepository.findByRegNumber(registrationNumber);
    }

    public List<Long> getTicketsByColour(String colour) {
        return ticketRepository.findByColour(colour);
    }
}
