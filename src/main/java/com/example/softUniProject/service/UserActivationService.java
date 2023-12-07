package com.example.softUniProject.service;

import com.example.softUniProject.events.UserRegistrationEvent;

public interface UserActivationService {

    void userRegistered(UserRegistrationEvent event);
    void cleanUpActivationLinks();

    String createActivationLink(String email);
}
