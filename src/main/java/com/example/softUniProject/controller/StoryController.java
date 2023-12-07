package com.example.softUniProject.controller;

import com.example.softUniProject.model.Entity.GenreEntity;
import com.example.softUniProject.model.Entity.StoryEntity;
import com.example.softUniProject.model.Enums.GenresEnum;
import com.example.softUniProject.model.dto.WriteStoryDto;
import com.example.softUniProject.repo.StoryRepository;
import com.example.softUniProject.service.GenreService;
import com.example.softUniProject.service.StoryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

public class StoryController {
    private final StoryService storyService;
    private final StoryRepository storyRepository;
    private final GenreService genreService;



    public StoryController(StoryService storyService, StoryRepository storyRepository, GenreService genreService) {
        this.storyService = storyService;
        this.storyRepository = storyRepository;
        this.genreService = genreService;
    }

    @ModelAttribute
    public GenresEnum[] genres() {
        return GenresEnum.values();
    }

    @GetMapping("/chooseWhatToDo")
    public String chooseWhatToDo() {
        return "chooseWhatToDo";
    }

    @PostMapping("/chooseWhatToDo")
    public String chooseWhatToDo(Model model) {
        return "redirect:/chooseWhatToDo";
    }

    @GetMapping("/createAStory")
    public String add(Model model) {
        if (!model.containsAttribute("writeStoryDto")) {
            model.addAttribute("writeStoryDto", WriteStoryDto.empty());
        }

        model.addAttribute("genres", genreService.getAllGenres());

        return "createAStory";
    }

    @PostMapping("/createAStory")
    public String add(WriteStoryDto writeStoryDto, BindingResult bindingResult,
                      RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("writeStoryDto", writeStoryDto);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.writeStoryDto", bindingResult);
            return "redirect:/createAStory";
        }

        storyService.addStory(writeStoryDto);


        return "redirect:/chooseWhatToDo";
    }

    @GetMapping("/story/read")
    public String read(@ModelAttribute("storyAddBindingModel") @Valid WriteStoryDto storyAddBindingModel) {
        return ("chooseWhichGenreToRead");
    }


    @PostMapping("/story/read")
    public String read(){
        return ("redirect:/chooseWhichGenreToRead");
    }

    @GetMapping("/genre/fantasy")
    public String readFantasy(Model model) {

        model.addAttribute("fantasy", storyRepository.findAllByGenre(GenresEnum.FANTASY));
        return ("fantasy");
    }

    @PostMapping("/genre/fantasy")
    public String readFantasy(){


        storyRepository.findAllByGenre(GenresEnum.FANTASY);

        return ("redirect:/fantasy");
    }



    @GetMapping("/genre/poetry")
    public String readPoetry(Model model) {
        model.addAttribute("poetry", storyRepository.findAllByGenre(GenresEnum.POETRY));

        return ("poetry");
    }
    @PostMapping("/genre/poetry")
    public String readPoetry(){


        storyRepository.findAllByGenre(GenresEnum.POETRY);

        return ("redirect:/poetry");
    }
//
//
@GetMapping("/genre/crime")
    public String readCrime(Model model) {
        model.addAttribute("crime", storyRepository.findAllByGenre(GenresEnum.CRIME));
        return ("crime");
    }
    @PostMapping("/genre/crime")
    public String readCrime(){


        storyRepository.findAllByGenre(GenresEnum.CRIME);

        return  ("redirect:/crime");
    }

@GetMapping("/genre/horror")
    public String readHorror(Model model) {
        model.addAttribute("horror", storyRepository.findAllByGenre(GenresEnum.HORROR));
        return ("horror");
    }
    @PostMapping("/genre/horror")
    public String readHorror(){


      storyRepository.findAllByGenre(GenresEnum.HORROR);


        return ("redirect:/horror");
    }

    @GetMapping("/genre/scifi")
    public String readSciFi(Model model) {
        model.addAttribute("scifi", storyRepository.findAllByGenre(GenresEnum.SCIENCE_FICTION));
        return ("scifi");
    }
    @PostMapping("/genre/scifi")
    public String readSciFi(){


        storyRepository.findAllByGenre(GenresEnum.SCIENCE_FICTION);


        return ("redirect:/scifi");
    }


    @PostMapping("/story/{id}")
    public String remove(@PathVariable("id") Long id){
        storyService.remove(id);
        return "redirect:/chooseWhatToDo";
    }



}