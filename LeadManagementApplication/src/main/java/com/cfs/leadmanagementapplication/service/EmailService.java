package com.cfs.leadmanagementapplication.service;

import com.cfs.leadmanagementapplication.entity.Lead;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${app.base-url}")
    private String baseUrl;

    public void sendLeadEmail(Lead lead, String token) throws MessagingException {

        String clickLink = baseUrl + "/api/track/click/" + token;

        String openTracking = baseUrl + "/api/track/open/" + token;

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(lead.getEmail());

        helper.setSubject("Thank You For Contacting Us");

        String html = """
                <html>
                <body>

                <h2>Hello %s</h2>

                <p>Thank you for contacting us.</p>

                <p><b>Your Requirement</b></p>

                <p>%s</p>

                <br>

                <a href="%s">
                    Learn More
                </a>

                <img src="%s"
                     width="1"
                     height="1"/>

                </body>
                </html>
                """.formatted(
                lead.getFullName(),
                lead.getRequirement(),
                clickLink,
                openTracking
        );

        helper.setText(html, true);

        mailSender.send(mimeMessage);

    }

}