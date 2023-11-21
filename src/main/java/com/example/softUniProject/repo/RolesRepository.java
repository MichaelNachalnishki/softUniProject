package com.example.softUniProject.repo;

import com.example.softUniProject.Model.Entity.ReadStoriesEntity;
import com.example.softUniProject.Model.Entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<RolesEntity, Long> {
}
