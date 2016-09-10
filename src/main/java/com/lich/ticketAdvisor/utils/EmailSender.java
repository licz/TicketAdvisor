package com.lich.ticketAdvisor.utils;

import com.lich.ticketAdvisor.Main;

import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * Created by l.sosnowski on 09/12/2015.
 */
public class EmailSender {

    private static final String TICKET_AVAILABLE = "Ticket available!";
    private static final String FROM = "ticket.advisor1";
    private static final String PASSWORD = "TicketAdvisor1";

    public void sendEmail() {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", FROM);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
//
//        Session session = Session.getDefaultInstance(props);
//        MimeMessage message = new MimeMessage(session);
//
//        try {
////            message.setFrom(new InternetAddress(FROM));
////            message.addRecipient(Message.RecipientType.TO, new InternetAddress(Main.email));
////
////            message.setSubject(TICKET_AVAILABLE);
////            message.setContent("<h3>Your ticket is now available - buy it quick!</h3><p>Event: " + Main.event + "</p><p>Ticket: " + Main.ticket + "</p>", "text/html; charset=utf-8");
////            Transport transport = session.getTransport("smtp");
////            transport.connect(host, FROM, PASSWORD);
////            transport.sendMessage(message, message.getAllRecipients());
////            transport.close();
//
//        } catch (AddressException ae) {
//            ae.printStackTrace();
//        } catch (MessagingException me) {
//            me.printStackTrace();
//        }
    }
}
