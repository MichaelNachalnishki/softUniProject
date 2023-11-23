package com.example.softUniProject.service;

import com.example.softUniProject.model.dto.StoryHomeViewModel;

public interface StoryService {


    StoryHomeViewModel getHomeViewData(String username, String genre);
}
