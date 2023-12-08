package com.example.softUniProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistsError extends RuntimeException{
    private final String id;
    public EmailAlreadyExistsError(String message, String id) {
        super(message);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
