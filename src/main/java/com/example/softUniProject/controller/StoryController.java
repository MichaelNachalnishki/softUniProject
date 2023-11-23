package com.example.softUniProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StoryController {
    @GetMapping("/story/add")
    public ModelAndView add(){
        return new ModelAndView("createAStory");
    }

}
