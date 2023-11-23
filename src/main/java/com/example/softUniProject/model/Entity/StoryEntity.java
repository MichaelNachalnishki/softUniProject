package com.example.softUniProject.model.Entity;

import com.example.softUniProject.model.Enums.AgeRestrictionEnum;
import com.example.softUniProject.model.Enums.GenresEnum;
import jakarta.persistence.*;

@Entity
public class StoryEntity extends BaseEntity{

    @ManyToOne
    private UserEntity authorName;
    private String storyName;
    private String storyContent;
    private int likes;
    @Enumerated(EnumType.STRING)
    private AgeRestrictionEnum ageRestriction;

    @Enumerated(EnumType.STRING)
    private GenresEnum genre;

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public UserEntity getAuthorName() {
        return authorName;
    }

    public void setAuthorName(UserEntity authorName) {
        this.authorName = authorName;
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public String getStoryContent() {
        return storyContent;
    }

    public void setStoryContent(String storyContent) {
        this.storyContent = storyContent;
    }

    public AgeRestrictionEnum getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestrictionEnum ageRestriction) {
        this.ageRestriction = ageRestriction;
    }


    public GenresEnum getGenre() {
        return genre;
    }

    public void setGenre(GenresEnum genre) {
        this.genre = genre;
    }
}
