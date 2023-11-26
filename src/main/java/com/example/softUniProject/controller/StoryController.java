package com.example.softUniProject.controller;

import com.example.softUniProject.model.dto.StoryAddBindingModel;
import com.example.softUniProject.service.StoryService;
import com.example.softUniProject.service.impl.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StoryController {

    private final LoggedUser loggedUser;
    private final StoryService storyService;

    public StoryController(LoggedUser loggedUser, StoryService storyService) {
        this.loggedUser = loggedUser;
        this.storyService = storyService;
    }

    @GetMapping("/story/write")
    public ModelAndView add() {
        return new ModelAndView("createAStory");
    }


    @PostMapping("/story/write")
    public ModelAndView add(@ModelAttribute("storyAddBindingModel") @Valid StoryAddBindingModel storyAddBindingModel, BindingResult bindingResult) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("createAStory");
        }

        storyService.add(storyAddBindingModel);


        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/story/read")
    public ModelAndView read(@ModelAttribute("storyAddBindingModel") @Valid StoryAddBindingModel storyAddBindingModel, BindingResult bindingResult) {
        return new ModelAndView("chooseWhichStoryToRead");
    }


    @PostMapping("/story/read")
    public ModelAndView read(){
        return  new ModelAndView("redirect:/chooseWhichStoryToRead");
    }
}
