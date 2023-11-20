package com.example.softUniProject.Model.Entity;

import com.example.softUniProject.Model.Enums.AgeRestrictionEnum;
import com.example.softUniProject.Model.Enums.GenresEnum;
import com.example.softUniProject.Model.Enums.StatusEnum;
import jakarta.persistence.*;

@Entity
public class StoryEntity extends BaseEntity{

    @ManyToOne
    private UserEntity authorName;
    private String storyName;
    private String storyContent;
    @Enumerated(EnumType.STRING)
    private AgeRestrictionEnum ageRestriction;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    @Enumerated(EnumType.STRING)
    private GenresEnum genre;


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

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public GenresEnum getGenre() {
        return genre;
    }

    public void setGenre(GenresEnum genre) {
        this.genre = genre;
    }
}
