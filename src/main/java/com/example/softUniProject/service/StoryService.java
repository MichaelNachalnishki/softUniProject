package com.example.softUniProject.service;

import com.example.softUniProject.model.dto.StoryAddBindingModel;
import com.example.softUniProject.model.dto.StoryHomeViewModel;

public interface StoryService {


    StoryHomeViewModel getHomeViewData(String username);

    void add(StoryAddBindingModel storyAddBindingModel);

    void remove(Long id);

}
