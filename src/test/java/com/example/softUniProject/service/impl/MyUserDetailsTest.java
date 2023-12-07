package com.example.softUniProject.service.impl;

import com.example.softUniProject.model.Entity.RolesEntity;
import com.example.softUniProject.model.Entity.UserEntity;
import com.example.softUniProject.model.Enums.RolesEnum;
import com.example.softUniProject.repo.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MyUserDetailsTest {
    private MyUserDetailsService serviceToTest;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new MyUserDetailsService(mockUserRepository);
    }

    @Test
    void UserNotFound() {
        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            serviceToTest.loadUserByUsername("user@example.com");
        });
    }

    @Test
    void testUserFound() {
        // Arrange
        UserEntity testUser = createTestUser();
        when(mockUserRepository.findByEmail(testUser.getEmail()))
                .thenReturn(Optional.of(testUser));

        //Act
        UserDetails userDetails = serviceToTest.loadUserByUsername(testUser.getEmail());

        //Assert
        Assertions.assertNotNull(userDetails);
        Assertions.assertEquals(testUser.getEmail(), userDetails.getUsername());

    }

    private static UserEntity createTestUser() {
        return new UserEntity()
                .setUsername("user")
                .setEmail("email@example.com")
                .setActive(true)
                .setPassword("password")
                .setRoles(List.of(new RolesEntity().setRole(RolesEnum.ADMIN)))
                .setRoles(List.of(new RolesEntity().setRole(RolesEnum.USER)));
    }
}