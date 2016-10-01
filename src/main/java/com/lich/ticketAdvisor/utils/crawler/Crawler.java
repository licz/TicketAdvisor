package com.lich.ticketAdvisor.utils.crawler;

import com.lich.ticketAdvisor.db.entities.Ticket;

/**
 * Created by leszek.sosnowski on 29/09/2016.
 */
public interface Crawler {
    boolean isTicketAvailable(Ticket ticket);
}
