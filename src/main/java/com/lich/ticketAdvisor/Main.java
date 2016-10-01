package com.lich.ticketAdvisor;

import com.lich.ticketAdvisor.utils.crawler.TicketAdvisorCrawler;
import com.lich.ticketAdvisor.utils.notifier.EmailNotifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by l.sosnowski on 09/12/2015.
 */
@SpringBootApplication
@PropertySource("classpath:advisor.properties")
public class Main {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public EmailNotifier getEmailNotifier() {
        return new EmailNotifier();
    }

    @Bean
    public TicketAdvisorCrawler getTicketAdvisorCrawler() {
        return new TicketAdvisorCrawler();
    }
}
