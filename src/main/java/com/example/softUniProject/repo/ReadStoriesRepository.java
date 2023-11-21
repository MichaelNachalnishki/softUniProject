package com.example.softUniProject.repo;

import com.example.softUniProject.Model.Entity.ReadStoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadStoriesRepository extends JpaRepository<ReadStoriesEntity, Long> {
}
