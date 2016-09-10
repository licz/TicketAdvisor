package com.lich.ticketAdvisor.services;

import com.lich.ticketAdvisor.db.entities.Ticket;
import com.lich.ticketAdvisor.db.entities.TicketRequest;
import com.lich.ticketAdvisor.db.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leszek.sosnowski on 19/08/2016.
 */
@Service
public class TicketService {
    @Autowired
    public TicketService (TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    TicketRepository ticketRepository;

    public Ticket addTicket(TicketRequest ticketRequest) {
        return ticketRepository.save(new Ticket(ticketRequest.getLink(), ticketRequest.getTicket(), ticketRequest.getEmail()));
    }

    public List<Ticket> getTickets() {
        Iterable<Ticket> iterator = ticketRepository.findAll();
        List<Ticket> ticketList = new ArrayList<>();
        iterator.forEach(ticketList::add);
        return ticketList;
    }
}
