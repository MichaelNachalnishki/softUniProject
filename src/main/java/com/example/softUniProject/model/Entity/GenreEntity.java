package com.example.softUniProject.model.Entity;

import com.example.softUniProject.model.Enums.GenresEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;


@Entity
@Table(name = "genres")
public class GenreEntity extends BaseEntity{


    @Enumerated(EnumType.STRING)
    private GenresEnum name;


    public GenresEnum getName() {
        return name;
    }

    public GenreEntity setName(GenresEnum name) {
        this.name = name;
        return this;
    }



}
