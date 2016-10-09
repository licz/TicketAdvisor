package com.lich.ticketAdvisor.db.repositories;

import com.lich.ticketAdvisor.db.entities.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by leszek.sosnowski on 19/08/2016.
 */
@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {
    List<Ticket> findByTicketFound(boolean ticketFound);
}
