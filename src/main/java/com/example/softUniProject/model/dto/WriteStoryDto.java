package com.example.softUniProject.model.dto;

import com.example.softUniProject.model.Entity.GenreEntity;
import com.example.softUniProject.model.Enums.AgeRestrictionEnum;
import com.example.softUniProject.model.Enums.GenresEnum;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.UUID;


public record WriteStoryDto(
                            String content,
                            String authorName,
                            String storyName,
                            GenresEnum genre) {

    public static WriteStoryDto empty() {
        return new WriteStoryDto(null,  null, null,null);
    }
}
