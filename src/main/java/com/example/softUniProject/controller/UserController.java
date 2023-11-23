package com.example.softUniProject.controller;

import com.example.softUniProject.model.dto.UserLoginDto;
import com.example.softUniProject.model.dto.UserRegisterDto;
import com.example.softUniProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginBindingModel") UserLoginDto userLoginFto){
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginBindingModel") @Valid UserLoginDto userLoginDto,
                              BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return new ModelAndView("login");
        }

        boolean hasSuccessfulLogin = userService.login(userLoginDto);

        if(!hasSuccessfulLogin){
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("hasLoginError", true);

            return modelAndView;
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel") UserRegisterDto userRegisterDto){
        return new ModelAndView("registerPage");
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel") @Valid UserRegisterDto userRegisterDto,
                                 BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return new ModelAndView("registerPage");
        }

        boolean hasSuccessfulRegistration = userService.register(userRegisterDto);

        if(!hasSuccessfulRegistration){
            ModelAndView modelAndView = new ModelAndView("registerPage");
            modelAndView.addObject("hasRegistrationError", true);

            return modelAndView;
        }

        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/logout")
    public ModelAndView logout(){
        this.userService.logout();
        return new ModelAndView("redirect:/");
    }
}