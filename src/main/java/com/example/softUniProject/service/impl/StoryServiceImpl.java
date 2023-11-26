package com.example.softUniProject.service.impl;

import com.example.softUniProject.model.Entity.GenreEntity;
import com.example.softUniProject.model.Entity.StoryEntity;
import com.example.softUniProject.model.dto.StoryAddBindingModel;
import com.example.softUniProject.model.dto.StoryDTO;
import com.example.softUniProject.model.dto.StoryHomeViewModel;
import com.example.softUniProject.repo.GenreRepository;
import com.example.softUniProject.repo.StoryRepository;

import com.example.softUniProject.service.StoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class StoryServiceImpl implements StoryService {


    private final StoryRepository storyRepository;
    private final GenreRepository genreRepository;

    public StoryServiceImpl(StoryRepository storyRepository, GenreRepository genreRepository) {
        this.storyRepository = storyRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public StoryHomeViewModel getHomeViewData(String username) {
            GenreEntity genre = new GenreEntity();

        List<StoryDTO> storiesWithGenre = storyRepository.findAllByGenre(genre).stream().map(StoryDTO::createFormStory).toList();

        return new StoryHomeViewModel(storiesWithGenre);
    }

    @Override
    public void add(StoryAddBindingModel storyAddBindingModel) {
        GenreEntity genre = genreRepository.findByName(storyAddBindingModel.getGenre());

        if (genre != null){
            StoryEntity story = new StoryEntity();
            story.setStoryContent(storyAddBindingModel.getContent());
            story.setGenre(genre);

            storyRepository.save(story);
        }
    }


    public void remove(Long id) {
        storyRepository.deleteById(id);
    }
}
