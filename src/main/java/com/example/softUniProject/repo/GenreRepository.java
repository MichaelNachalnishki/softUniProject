package com.example.softUniProject.repo;

import com.example.softUniProject.model.Entity.GenreEntity;
import com.example.softUniProject.model.Enums.GenresEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {

    Optional<GenreEntity> findByName(GenresEnum genre);

    @Query("SELECT b FROM GenreEntity b")
    List<GenreEntity> getAllGenres();
}
