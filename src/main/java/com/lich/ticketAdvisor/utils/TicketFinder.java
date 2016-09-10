package com.lich.ticketAdvisor.utils;

import org.jsoup.nodes.Element;

/**
 * Created by l.sosnowski on 09/12/2015.
 */
public class TicketFinder {
    final static public String ONSALE = "onsale";

    public boolean foundTicket(Element contents) {
        String htmlClass = contents.className();

        return htmlClass.contains(ONSALE);
    }
}
