package com.example.softUniProject.model.dto;

import com.example.softUniProject.model.Entity.StoryEntity;
import com.example.softUniProject.model.Entity.UserEntity;
import com.example.softUniProject.model.Enums.AgeRestrictionEnum;
import com.example.softUniProject.model.Enums.GenresEnum;


public class StoryDTO {

    private Long id;
    private UserEntity authorName;
    private String storyName;
    private String storyContent;
    private int likes;
    private AgeRestrictionEnum ageRestriction;
    private GenresEnum genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
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


    public static StoryDTO createFormStory(StoryEntity story){
        StoryDTO storyDTO = new StoryDTO();
        storyDTO.setId(story.getId());
        storyDTO.setStoryContent(story.getStoryContent());
        storyDTO.setAuthorName(story.getAuthorName());
        storyDTO.setStoryName(story.getStoryName());
        storyDTO.setGenre(story.getGenre());
        storyDTO.setAgeRestriction(story.getAgeRestriction());
        storyDTO.setLikes(storyDTO.getLikes());


        return storyDTO;
    }
}
