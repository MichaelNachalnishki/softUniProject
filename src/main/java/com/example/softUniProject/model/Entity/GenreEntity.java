package com.example.softUniProject.model.Entity;

import com.example.softUniProject.model.Enums.GenresEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "genres")
public class GenreEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private GenresEnum name;

    @OneToMany(mappedBy = "genre")
    private Set<StoryEntity> stories;

    public GenresEnum getName() {
        return name;
    }

    public Set<StoryEntity> getStories() {
        return stories;
    }

    public void setTasks(Set<StoryEntity> tasks) {
        this.stories = stories;
    }


}
