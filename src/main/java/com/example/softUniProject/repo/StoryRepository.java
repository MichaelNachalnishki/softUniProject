package com.example.softUniProject.repo;

import com.example.softUniProject.model.Entity.GenreEntity;
import com.example.softUniProject.model.Entity.StoryEntity;
import com.example.softUniProject.model.Enums.GenresEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StoryRepository extends JpaRepository<StoryEntity, Long> {

    List<StoryEntity> findAllByGenre(GenresEnum genre);


    void deleteById(long id);

    @Query("SELECT b FROM StoryEntity b")
    List<StoryEntity> getAllStories();


}
