package com.example.softUniProject.repo;

import com.example.softUniProject.Model.Entity.ReadStoriesEntity;
import com.example.softUniProject.Model.Entity.WrittenStoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WrittenStoriesRepository extends JpaRepository<WrittenStoriesEntity, Long> {
}
