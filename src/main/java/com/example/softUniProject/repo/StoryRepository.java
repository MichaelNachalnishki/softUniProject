package com.example.softUniProject.repo;

import com.example.softUniProject.Model.Entity.ReadStoriesEntity;
import com.example.softUniProject.Model.Entity.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<StoryEntity, Long> {
}
