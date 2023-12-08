package com.example.softUniProject.controller;

import com.example.softUniProject.exceptions.EmailAlreadyExistsError;
import com.example.softUniProject.model.Entity.UserActivationLinkEntity;
import com.example.softUniProject.model.dto.UserRegisterDto;
import com.example.softUniProject.service.UserActivationService;
import com.example.softUniProject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserRegistrationController {

    private final UserService userService;



    public UserRegistrationController(UserService userService, UserActivationService userActivationService) {
        this.userService = userService;

    }

    @GetMapping("/register")
    public String register(){
        return "registerPage";
    }

    @PostMapping("/register")
    public String register(UserRegisterDto userRegisterDto){

        if(userService.containsEmail(userRegisterDto.getEmail())){
            return "redirect:/register";

        }else{
            userService.registerUser(userRegisterDto);
            return ("redirect:/");
        }


    }




}