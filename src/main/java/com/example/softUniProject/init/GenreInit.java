package com.example.softUniProject.init;

import com.example.softUniProject.model.Entity.GenreEntity;
import com.example.softUniProject.model.Enums.GenresEnum;
import com.example.softUniProject.repo.GenreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class GenreInit implements CommandLineRunner {

private final GenreRepository genreRepository;

    public GenreInit(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long count = genreRepository.count();

        if(count == 0){

            List<GenreEntity> genres = new ArrayList<>();

            Arrays.stream(GenresEnum.values()).forEach(genreName -> {
                GenreEntity genre = new GenreEntity();
                genre.setName(genreName);
                genres.add(genre);
            });

            genreRepository.saveAll(genres);
        }
    }
}
