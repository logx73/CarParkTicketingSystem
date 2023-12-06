package com.psystem.repository.ticket;

import com.psystem.model.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    @Query(value = "select t.ticketId from ticket as t inner join car as c on t.car_id = c.id where c.registrationNumber = :regNumber",nativeQuery = true)
    Long findByRegNumber(@Param("regNumber") String regNumber);

    @Query(value = "select t.ticketId from ticket as t inner join car as c on t.car_id = c.id where c.colour = :colour",nativeQuery = true)
    List<Long> findByColour(@Param("colour") String colour);
}
