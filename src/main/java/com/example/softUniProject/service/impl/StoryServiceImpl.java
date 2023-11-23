package com.example.softUniProject.service.impl;

import com.example.softUniProject.model.dto.StoryDTO;
import com.example.softUniProject.model.dto.StoryHomeViewModel;
import com.example.softUniProject.repo.StoryRepository;

import com.example.softUniProject.service.StoryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoryServiceImpl implements StoryService {


    private final StoryRepository storyRepository;

    public StoryServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override
    public StoryHomeViewModel getHomeViewData(String username, String genre) {


        List<StoryDTO> storiesWithGenre = storyRepository.findAllByGenre(genre).stream().map(StoryDTO::createFormStory).toList();

        return new StoryHomeViewModel(storiesWithGenre);
    }
}
