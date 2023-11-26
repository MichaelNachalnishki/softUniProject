package com.example.softUniProject.repo;

import com.example.softUniProject.model.Entity.GenreEntity;
import com.example.softUniProject.model.Entity.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoryRepository extends JpaRepository<StoryEntity, Long> {

    List<StoryEntity> findAllByGenre(GenreEntity genre);


}
