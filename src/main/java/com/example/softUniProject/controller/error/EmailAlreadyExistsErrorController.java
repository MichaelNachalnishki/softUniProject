package com.example.softUniProject.controller.error;

import com.example.softUniProject.exceptions.EmailAlreadyExistsError;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class EmailAlreadyExistsErrorController {

    @ExceptionHandler(EmailAlreadyExistsError.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String emailAlreadyExistsError() {
        throw new EmailAlreadyExistsError("Email already exists", "email");
    }
}

