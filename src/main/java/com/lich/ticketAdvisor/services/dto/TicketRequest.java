package com.lich.ticketAdvisor.services.dto;

/**
 * Created by leszek.sosnowski on 19/08/2016.
 */
public class TicketRequest {
    private String link;
    private String ticket;
    private String email;

    public TicketRequest(String link, String ticket, String email) {
        this.link = link;
        this.ticket = ticket;
        this.email = email;
    }

    public TicketRequest() {

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
}
