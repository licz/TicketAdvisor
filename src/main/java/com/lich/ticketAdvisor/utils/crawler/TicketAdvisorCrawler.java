package com.lich.ticketAdvisor.utils.crawler;

import com.lich.ticketAdvisor.db.entities.Ticket;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * Created by leszek.sosnowski on 29/09/2016.
 */
public class TicketAdvisorCrawler implements Crawler {

    private static final String ONSALE = "onsale";
    private static final String TICKET = "ticket-";

    @Override
    public boolean isTicketAvailable(Ticket ticket) {

        String link = ticket.getLink();
        String ticketName = ticket.getTicket();

        Document doc = null;
        try {
            doc = Jsoup
                    .connect(link)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element contents = doc.getElementById(TICKET+ticketName);

        String htmlClass = contents.className();

        return htmlClass.contains(ONSALE);
    }
}
