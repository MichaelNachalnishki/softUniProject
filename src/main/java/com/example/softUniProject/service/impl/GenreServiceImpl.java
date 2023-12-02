package com.example.softUniProject.service.impl;

import com.example.softUniProject.model.Entity.GenreEntity;
import com.example.softUniProject.model.Enums.GenresEnum;
import com.example.softUniProject.model.dto.GenreDTO;
import com.example.softUniProject.repo.GenreRepository;
import com.example.softUniProject.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<GenreDTO> getAllGenres() {
        return genreRepository.getAllGenres().stream()
                .map(genre -> new GenreDTO(genre.getId(), genre.getName().toString()))
                .sorted(Comparator.comparing(GenreDTO::name))
                .collect(Collectors.toList());

    }

    @Override
    public GenreEntity getGenreByName(GenresEnum name) {
        return genreRepository.findByName(name).orElseThrow();
    }
}
