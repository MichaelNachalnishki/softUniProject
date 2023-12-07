package com.example.softUniProject.model.Entity;

import com.example.softUniProject.model.Enums.GenresEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "story")
public class StoryEntity extends BaseEntity {

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
