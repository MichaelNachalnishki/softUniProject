package com.example.softUniProject.repo;

import com.example.softUniProject.model.Entity.GenreEntity;
import com.example.softUniProject.model.Enums.GenresEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {

    GenreEntity findByName(GenresEnum genre);
}
