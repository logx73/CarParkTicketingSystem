package com.psystem.controller.ticket;

import com.psystem.model.ticket.Ticket;
import com.psystem.service.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping(value = "/v1/parking-management/ticket")
    public Ticket saveTicket(@RequestBody Ticket ticket){
        return ticketService.saveTicket(ticket);
    }

    @GetMapping(value = "/v1/parking-managment/ticket")
    public Long getTicketDetailsByRegistrationNumber(@RequestParam String registrationNumber){
        return ticketService.getTicketByRegistrationNumber(registrationNumber);
    }

    @GetMapping(value = "/v1/parking-managment/tickets")
    public List<Long> getTicketsByColour(@RequestParam String colour){
        return ticketService.getTicketsByColour(colour);
    }
}
