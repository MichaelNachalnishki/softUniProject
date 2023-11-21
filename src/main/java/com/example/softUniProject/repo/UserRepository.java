package com.example.softUniProject.repo;

import com.example.softUniProject.Model.Entity.ReadStoriesEntity;
import com.example.softUniProject.Model.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
