package banksystem.service;

import banksystem.dao.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    private static final Logger LOG = LoggerFactory.getLogger(MailSenderService.class);

    @Async
    public void sendEmail(MimeMessage email) {
        javaMailSender.send(email);
    }

    public void sendVerification(String token, Client client) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        String htmlMsg = "<h3>To confirm your account, please click here : "
                + "<a href=\"http://localhost:8080/bank/api/auth/confirm-account?token="
                + token + "\"> Click </a></h3>";

        try {
            helper.setText(htmlMsg, true);
            helper.setTo(client.getEmail());
            helper.setSubject("Complete Registration!");
            helper.setFrom("Bank");
        } catch (MessagingException e) {
            LOG.error("Error sending verification letter", e);
            throw new MessagingException();
        }

        sendEmail(mimeMessage);
    }
}
