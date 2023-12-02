package com.example.softUniProject.model.dto;

import com.example.softUniProject.model.Enums.AgeRestrictionEnum;
import com.example.softUniProject.model.Enums.GenresEnum;

import java.util.List;


public record StoryDTO(String authorName, String storyName, String storyContent,
                        GenresEnum genre) {

}
