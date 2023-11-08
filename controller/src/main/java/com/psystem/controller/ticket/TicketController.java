package com.psystem.controller.ticket;

import com.psystem.model.ticket.Ticket;
import com.psystem.service.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping(value = "/v1/parking-management/ticket")
    public Ticket saveTicket(@RequestBody Ticket ticket){
        return ticketService.saveTicket(ticket);
    }

}
