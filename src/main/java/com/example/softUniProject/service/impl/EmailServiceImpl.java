package com.example.softUniProject.service.impl;

import com.example.softUniProject.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailServiceImpl implements EmailService {

    private final TemplateEngine templateEngine;
    private final JavaMailSender javaMailSender;
    private final String storyappEmail;

    public EmailServiceImpl(TemplateEngine templateEngine, JavaMailSender javaMailSender, @Value("${mail.storyapp}")String storyappEmail){
        this.templateEngine = templateEngine;
        this.javaMailSender = javaMailSender;
        this.storyappEmail = storyappEmail;
    }



    @Override
    public void sentRegisterEmail(String email, String username, String activationLink) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(email);
            helper.setFrom(storyappEmail);
            helper.setReplyTo(storyappEmail);
            helper.setSubject("Welcome to StoryApp");
            helper.setText(generateRegistrationEmailBody(username, activationLink), true);
            javaMailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateRegistrationEmailBody(String username, String activationCode) {
        Context context = new Context();
        context.setVariable("username", username);
        context.setVariable("activation_code", activationCode);

        return templateEngine.process("email/registration-email", context);
    }


}
