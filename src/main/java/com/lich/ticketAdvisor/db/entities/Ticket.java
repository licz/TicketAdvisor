package com.lich.ticketAdvisor.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by leszek.sosnowski on 19/08/2016.
 */
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private String link;

    @Column
    private String ticket;

    @Column
    private String email;

    @Column
    private boolean emailSent;

    @Column
    private boolean ticketFound;

    public Ticket() {

    }

    public Ticket(String link, String ticket, String email) {
        this.link = link;
        this.ticket = ticket;
        this.email = email;
    }

    public Ticket(String link, String ticket, String email, boolean emailSent, boolean ticketFound) {
        this.link = link;
        this.ticket = ticket;
        this.email = email;
        this.emailSent = emailSent;
        this.ticketFound = ticketFound;
    }
}
