package com.example.softUniProject.model.Entity;

import com.example.softUniProject.model.Enums.GenresEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

import java.util.UUID;


@Entity
public class WrittenStoriesEntity extends BaseEntity{
    private UUID uuid;
    private String name;
    private String content;
    @ManyToOne
    private UserEntity author;
    @ManyToOne
    private GenreEntity genre;

    public String getContent() {
        return content;
    }

    public WrittenStoriesEntity setContent(String content) {
        this.content = content;
        return  this;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public WrittenStoriesEntity setGenre(GenreEntity genre) {
        this.genre = genre;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public WrittenStoriesEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public String getName() {
        return name;
    }

    public WrittenStoriesEntity setName(String name) {
        this.name = name;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public WrittenStoriesEntity setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }
}
