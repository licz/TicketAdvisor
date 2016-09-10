package com.lich.ticketAdvisor.utils;


import org.jsoup.nodes.Element;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by l.sosnowski on 09/12/2015.
 */
public class Processor implements Runnable {

    ScheduledExecutorService executor =
            Executors.newSingleThreadScheduledExecutor();

    PageReader pageReader = new PageReader();
    TicketFinder ticketFinder = new TicketFinder();
    EmailSender emailSender = new EmailSender();

    public void process() {
        executor.scheduleAtFixedRate(this, 0, 90, TimeUnit.SECONDS);
    }

    @Override
    public void run() {
        Element element = pageReader.getContents();
        if (ticketFinder.foundTicket(element)) {
            System.out.println("Just found a ticket!");
            emailSender.sendEmail();
            System.exit(0);
        }
    }
}
