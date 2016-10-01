package com.lich.ticketAdvisor.utils.notifier;

/**
 * Created by leszek.sosnowski on 29/09/2016.
 */
public interface Notifier {
    void notify(String recipient, String event, String ticket);
}
