package com.lich.ticketAdvisor.db.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by leszek.sosnowski on 19/08/2016.
 */
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String link;

    private String ticket;

    private String email;

    private boolean ticketFound;

    public Ticket() {

    }

    public Ticket(String link, String ticket, String email) {
        this.link = link;
        this.ticket = ticket;
        this.email = email;
    }

    public Ticket(String link, String ticket, String email, boolean ticketFound) {
        this.link = link;
        this.ticket = ticket;
        this.email = email;
        this.ticketFound = ticketFound;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isTicketFound() {
        return ticketFound;
    }

    public void setTicketFound(boolean ticketFound) {
        this.ticketFound = ticketFound;
    }
}
