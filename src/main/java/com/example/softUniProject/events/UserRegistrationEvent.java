package com.example.softUniProject.events;

import org.springframework.context.ApplicationEvent;

public class UserRegistrationEvent extends ApplicationEvent {
    private final String email;
    private final String usernames;

    public UserRegistrationEvent(Object source, String email, String usernames) {
        super(source);
        this.email = email;
        this.usernames = usernames;
    }

    public String getEmail() {
        return email;
    }

    public String getUsernames() {
        return usernames;
    }
}
