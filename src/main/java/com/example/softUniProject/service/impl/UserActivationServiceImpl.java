package com.example.softUniProject.service.impl;

import com.example.softUniProject.events.UserRegistrationEvent;
import com.example.softUniProject.exceptions.ObjectNotFoundException1;
import com.example.softUniProject.model.Entity.UserActivationLinkEntity;
import com.example.softUniProject.repo.UserActivationLinkRepository;
import com.example.softUniProject.repo.UserRepository;
import com.example.softUniProject.service.EmailService;
import com.example.softUniProject.service.UserActivationService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Random;

@Service
public class UserActivationServiceImpl implements UserActivationService {
    private static final String ACTIVATION_CODE_SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-=_+[]{}|;:'\",.<>/?";
    private static final int ACTIVATION_CODE_LENGTH = 20;
    private final EmailService emailService;
    private final UserRepository userRepository;
    private final UserActivationLinkRepository userActivationLinkRepository;

    public UserActivationServiceImpl(EmailService emailService, UserRepository userRepository, UserActivationLinkRepository userActivationLinkRepository) {
        this.emailService = emailService;
        this.userRepository = userRepository;
        this.userActivationLinkRepository = userActivationLinkRepository;
    }
    @EventListener(UserRegistrationEvent.class)
    @Override
    public void userRegistered(UserRegistrationEvent event) {

        String activationLink = createActivationLink(event.getEmail());
        emailService.sentRegisterEmail(event.getEmail(), event.getUsernames(), activationLink);
    }

    @Override
    public void cleanUpActivationLinks() {

    }

    @Override
    public String createActivationLink(String email) {
        String activationCode = generateActivationCode();

        UserActivationLinkEntity userActivationLinkEntity = new UserActivationLinkEntity();
        userActivationLinkEntity.setActivationCode(activationCode);
        userActivationLinkEntity.setCreated(Instant.now());
        userActivationLinkEntity.setUser(userRepository.findByEmail(email).orElseThrow(() -> new ObjectNotFoundException1("User not found!", "User")));
        userActivationLinkRepository.save(userActivationLinkEntity);
        return activationCode;
    }

    private static String generateActivationCode()
    {
        Random random = new SecureRandom();
        StringBuilder activationCode = new StringBuilder();
        for (int i = 0; i < ACTIVATION_CODE_LENGTH; i++) {
            int index = random.nextInt(ACTIVATION_CODE_SYMBOLS.length());
            activationCode.append(ACTIVATION_CODE_SYMBOLS.charAt(index));
        }
        return activationCode.toString();
    }
}
