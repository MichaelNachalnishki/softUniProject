package com.example.softUniProject.service;

import com.example.softUniProject.model.dto.WriteStoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface StoryService {
    void addStory(WriteStoryDto storyAddBindingModel);



    void remove(Long id);



}
