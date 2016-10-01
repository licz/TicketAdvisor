package com.lich.ticketAdvisor.utils;


import com.lich.ticketAdvisor.db.entities.Ticket;
import com.lich.ticketAdvisor.db.repositories.TicketRepository;
import com.lich.ticketAdvisor.utils.crawler.Crawler;
import com.lich.ticketAdvisor.utils.notifier.Notifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by l.sosnowski on 09/12/2015.
 */
@Component
public class Processor implements Runnable {

    @Autowired
    public Processor(Crawler crawler, Notifier notifier, TicketRepository ticketRepository) {
        this.crawler = crawler;
        this.notifier = notifier;
        this.ticketRepository = ticketRepository;

        executor.scheduleAtFixedRate(this, 0, 60, TimeUnit.SECONDS);
    }

    ScheduledExecutorService executor =
            Executors.newSingleThreadScheduledExecutor();

    private Crawler crawler;
    private Notifier notifier;

    private TicketRepository ticketRepository;

    @Override
    public void run() {
        Iterable<Ticket> iterator = ticketRepository.findAll();
        List<Ticket> ticketList = new ArrayList<>();
        iterator.forEach(ticketList::add);

        for (Ticket ticket: ticketList) {
            boolean ticketFound = false;
            if (!ticket.isTicketFound()) {
                ticketFound = crawler.isTicketAvailable(ticket);
            }

            if (ticketFound) {
                notifier.notify(ticket.getEmail(), ticket.getLink(), ticket.getTicket());
                ticket.setEmailSent(true);
                ticket.setTicketFound(true);
            }
        }
    }
}
