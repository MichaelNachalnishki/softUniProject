package com.example.softUniProject.model.dto;

import java.util.ArrayList;
import java.util.List;

public class StoryHomeViewModel {
    private List<StoryDTO> stories;
    private List<StoryDTO> storiesWithGivenGenre;
    public List<StoryDTO> storiesToRead() {
        return stories;
    }
    public StoryHomeViewModel(){
        this(new ArrayList<>());
    }

    public StoryHomeViewModel(List<StoryDTO> storiesFromGenre){

        this.storiesWithGivenGenre = storiesFromGenre;

    }



    public List<StoryDTO> storiesFromGenre() {
        return storiesWithGivenGenre;
    }

    public void setStoriesWithGivenGenre(List<StoryDTO> storiesWithGivenGenre) {
        this.storiesWithGivenGenre = storiesWithGivenGenre;
    }
}
