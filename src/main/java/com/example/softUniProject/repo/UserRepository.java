package com.example.softUniProject.repo;

import com.example.softUniProject.model.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

    boolean existsByUsernameOrEmail(String username, String email);
}
