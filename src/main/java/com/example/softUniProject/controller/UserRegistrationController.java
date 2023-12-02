package com.example.softUniProject.controller;

import com.example.softUniProject.model.dto.UserRegisterDto;
import com.example.softUniProject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(){
        return "registerPage";
    }

    @PostMapping("/register")
    public String register(UserRegisterDto userRegisterDto){

     userService.registerUser(userRegisterDto);

        return ("redirect:/");
    }


}