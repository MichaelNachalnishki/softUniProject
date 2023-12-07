package com.example.softUniProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ObjectNotFoundException1 extends RuntimeException{

    private final String id;
    public ObjectNotFoundException1(String message, String id) {
        super(message);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
