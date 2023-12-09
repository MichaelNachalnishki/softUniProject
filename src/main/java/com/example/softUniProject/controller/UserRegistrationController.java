package com.example.softUniProject.controller;

import com.example.softUniProject.exceptions.EmailAlreadyExistsError;
import com.example.softUniProject.model.Entity.UserActivationLinkEntity;
import com.example.softUniProject.model.dto.UserRegisterDto;
import com.example.softUniProject.service.UserActivationService;
import com.example.softUniProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserRegistrationController {

    private final UserService userService;


    public UserRegistrationController(UserService userService, UserActivationService userActivationService) {
        this.userService = userService;

    }

    @GetMapping("/register")
    public String register(@ModelAttribute("userRegisterDto") UserRegisterDto userRegisterDto) {
        return "registerPage";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("userRegisterDto") UserRegisterDto userRegisterDto,
                           Model model) {

            userService.registerUser(userRegisterDto);
            return "redirect:/login";



    }
}



