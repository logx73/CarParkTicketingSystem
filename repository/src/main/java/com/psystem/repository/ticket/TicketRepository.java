package com.psystem.repository.ticket;

import com.psystem.model.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
