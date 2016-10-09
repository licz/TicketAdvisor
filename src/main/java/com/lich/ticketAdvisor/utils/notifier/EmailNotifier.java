package com.lich.ticketAdvisor.utils.notifier;

import org.springframework.beans.factory.annotation.Value;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by l.sosnowski on 09/12/2015.
 */
public class EmailNotifier implements Notifier {

    private static final String STARTTLS = "mail.smtp.starttls.enable";
    private static final String HOST = "mail.smtp.host";
    private static final String USER = "mail.smtp.user";
    private static final String PASSWORD = "mail.smtp.password";
    private static final String PORT = "mail.smtp.port";
    private static final String AUTH = "mail.smtp.auth";
    public static final String TEXT_HTML_CHARSET_UTF_8 = "text/html; charset=utf-8";
    public static final String SMTP = "smtp";

    @Value("${ticket.advisor.mail.host}")
    private String host;

    @Value("${ticket.advisor.mail.starttls.enable}")
    private String starttls;

    @Value("${ticket.advisor.mail.login}")
    private String login;

    @Value("${ticket.advisor.mail.password}")
    private String password;

    @Value("${ticket.advisor.mail.port}")
    private String port;

    @Value("${ticket.advisor.mail.starttls.enable}")
    private String auth;

    @Value("${ticket.advisor.mail.subject}")
    private String subject;

    @Value("${ticket.advisor.mail.content}")
    private String content;

    @Override
    public void notify(String recipient, String event, String ticket) {
        Properties props = System.getProperties();
        props.put(STARTTLS, starttls);
        props.put(HOST, host);
        props.put(USER, login);
        props.put(PASSWORD, password);
        props.put(PORT, port);
        props.put(AUTH, auth);

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(login));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            String emailContent = String.format(content, event, ticket);

            message.setSubject(subject);
            message.setContent(emailContent, TEXT_HTML_CHARSET_UTF_8);
            Transport transport = session.getTransport(SMTP);
            transport.connect(host, login, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}
