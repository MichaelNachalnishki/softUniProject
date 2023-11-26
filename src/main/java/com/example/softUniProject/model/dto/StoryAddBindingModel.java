package com.example.softUniProject.model.dto;

import com.example.softUniProject.model.Enums.GenresEnum;


public class StoryAddBindingModel {
    private String content;
    private GenresEnum genre;
    //TODO make genre notnull


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public GenresEnum getGenre() {
        return genre;
    }

    public void setGenre(GenresEnum genre) {
        this.genre = genre;
    }
}
