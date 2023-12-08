package com.example.softUniProject.service.impl;

import com.example.softUniProject.model.Entity.GenreEntity;
import com.example.softUniProject.model.Entity.StoryEntity;
import com.example.softUniProject.model.Entity.UserEntity;
import com.example.softUniProject.model.dto.GenreDTO;
import com.example.softUniProject.model.dto.WriteStoryDto;
import com.example.softUniProject.repo.GenreRepository;
import com.example.softUniProject.repo.StoryRepository;
import com.example.softUniProject.repo.UserRepository;
import com.example.softUniProject.service.StoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StoryServiceImpl implements StoryService {


    private final StoryRepository storyRepository;
    private final GenreRepository genreRepository;
    private final UserRepository userRepository;

    public StoryServiceImpl(StoryRepository storyRepository, GenreRepository genreRepository, UserRepository userRepository) {
        this.storyRepository = storyRepository;
        this.genreRepository = genreRepository;
        this.userRepository = userRepository;
    }






    @Override
    public void addStory(WriteStoryDto writeStoryDto) {


        StoryEntity newStory = map(writeStoryDto);


        try {
            storyRepository.save(newStory);
            System.out.println("Story added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void remove(Long id) {
        storyRepository.deleteById(id);
    }


    private static StoryEntity map(WriteStoryDto writeStoryDto) {
        return new StoryEntity()
                .setStoryContent(writeStoryDto.content())
                .setGenre(writeStoryDto.genre())
                .setAuthorName(writeStoryDto.authorName())
                .setStoryName(writeStoryDto.storyName());
    }


}
