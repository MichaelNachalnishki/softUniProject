package com.example.softUniProject.service;

public interface EmailService {
    void sentRegisterEmail(String email, String username, String activationLink);

}
