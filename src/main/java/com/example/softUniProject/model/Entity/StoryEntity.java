package com.example.softUniProject.model.Entity;

import com.example.softUniProject.model.Enums.GenresEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "story")
public class StoryEntity extends BaseEntity {
    @Column(nullable = false)
    private String authorName;
    @Column(nullable = false)
    private String storyName;
    @Column(nullable = false)
    private String storyContent;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
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
