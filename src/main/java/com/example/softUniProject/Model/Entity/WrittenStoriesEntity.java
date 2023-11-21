package com.example.softUniProject.Model.Entity;

import jakarta.persistence.Entity;


@Entity
public class WrittenStoriesEntity extends BaseEntity{

    private String name;
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
