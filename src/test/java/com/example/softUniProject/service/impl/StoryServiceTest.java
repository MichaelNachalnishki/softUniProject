package com.example.softUniProject.service.impl;

import com.example.softUniProject.model.Entity.StoryEntity;
import com.example.softUniProject.model.Enums.GenresEnum;
import com.example.softUniProject.model.dto.WriteStoryDto;
import com.example.softUniProject.repo.GenreRepository;
import com.example.softUniProject.repo.StoryRepository;
import com.example.softUniProject.repo.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class StoryServiceTest {

    @Mock
    private StoryRepository storyRepository;

    @Mock
    private GenreRepository genreRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private StoryServiceImpl storyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addStory_Success() {
        // Given
        WriteStoryDto writeStoryDto = createWriteStoryDto();

        // When
        storyService.addStory(writeStoryDto);

        // Then
        verify(storyRepository).save(any(StoryEntity.class));
        // Add more assertions if needed
    }

    @Test
    void removeStory_Success() {
        // Given
        Long storyId = 1L;

        // When
        storyService.remove(storyId);

        // Then
        verify(storyRepository).deleteById(storyId);
        // Add more assertions if needed
    }

    private WriteStoryDto createWriteStoryDto() {
        // Create and return a sample WriteStoryDto for testing
        // You can customize this method based on your requirements
        return new WriteStoryDto("Sample content", "Sample author", "Sample story name", GenresEnum.FANTASY);

    }

}
