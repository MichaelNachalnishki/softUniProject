package com.example.softUniProject.service;

import com.example.softUniProject.model.Entity.GenreEntity;
import com.example.softUniProject.model.Enums.GenresEnum;
import com.example.softUniProject.model.dto.GenreDTO;

import java.util.List;

public interface GenreService{
    List<GenreDTO> getAllGenres();

    GenreEntity getGenreByName(GenresEnum name);
}
