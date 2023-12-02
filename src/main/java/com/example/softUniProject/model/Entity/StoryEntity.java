package com.example.softUniProject.model.Entity;

import com.example.softUniProject.model.Enums.AgeRestrictionEnum;
import com.example.softUniProject.model.Enums.GenresEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "story")
public class StoryEntity extends BaseEntity{

    private String authorName;
    private String storyName;
    private String storyContent;
    @Enumerated(EnumType.STRING)
    private GenresEnum genre;

    public String getAuthorName() {
        return authorName;
    }

    public StoryEntity setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public String getStoryName() {
        return storyName;
    }

    public StoryEntity setStoryName(String storyName) {
        this.storyName = storyName;
        return this;
    }

    public String getStoryContent() {
        return storyContent;
    }

    public StoryEntity setStoryContent(String storyContent) {
        this.storyContent = storyContent;
        return this;
    }

    public GenresEnum getGenre() {
        return genre;
    }

    public StoryEntity setGenre(GenresEnum genre) {
        this.genre = genre;
        return this;
    }
}
