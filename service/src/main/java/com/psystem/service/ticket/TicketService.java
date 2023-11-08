package com.psystem.service.ticket;

import com.psystem.model.ticket.Ticket;
import com.psystem.repository.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket saveTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }
}
