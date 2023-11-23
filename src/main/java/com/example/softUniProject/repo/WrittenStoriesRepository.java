package com.example.softUniProject.repo;

import com.example.softUniProject.model.Entity.WrittenStoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WrittenStoriesRepository extends JpaRepository<WrittenStoriesEntity, Long> {
}
