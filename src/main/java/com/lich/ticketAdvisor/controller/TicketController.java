package com.lich.ticketAdvisor.controller;

import com.lich.ticketAdvisor.db.entities.Ticket;
import com.lich.ticketAdvisor.db.entities.TicketRequest;
import com.lich.ticketAdvisor.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by leszek.sosnowski on 19/08/2016.
 */
@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    TicketService ticketService;

    @RequestMapping(value = "/ticket", method = RequestMethod.PUT)
    public @ResponseBody
    Ticket addTicket(@RequestBody TicketRequest ticketRequest) {
        return ticketService.addTicket(ticketRequest);
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public @ResponseBody
    List<Ticket> getTickets() {
        return ticketService.getTickets();
    }
}
