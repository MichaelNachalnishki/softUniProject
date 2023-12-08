package com.example.softUniProject.service.impl;

import com.example.softUniProject.events.UserRegistrationEvent;
import com.example.softUniProject.exceptions.ObjectNotFoundException1;
import com.example.softUniProject.model.Entity.RolesEntity;
import com.example.softUniProject.model.Entity.UserActivationLinkEntity;
import com.example.softUniProject.model.Entity.UserEntity;
import com.example.softUniProject.model.Enums.RolesEnum;
import com.example.softUniProject.repo.UserActivationLinkRepository;
import com.example.softUniProject.repo.UserRepository;
import com.example.softUniProject.service.EmailService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class UserActivationTest {


    @Mock
    private EmailService emailService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserActivationLinkRepository userActivationLinkRepository;

    @InjectMocks
    private UserActivationServiceImpl userActivationService;




    @Test
    void userRegistered_ShouldThrowExceptionIfUserNotFound() {
        // Arrange
        UserRegistrationEvent event = new UserRegistrationEvent("nonexistent@example.com", "username", "password");

        // Make userRepository.findByEmail lenient
        lenient().when(userRepository.findByEmail(event.getEmail())).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ObjectNotFoundException1.class, () -> userActivationService.userRegistered(event));

        // Verify that emailService and userActivationLinkRepository were not called
        verify(emailService, never()).sentRegisterEmail(anyString(), anyString(), anyString());
        verify(userActivationLinkRepository, never()).save(any(UserActivationLinkEntity.class));
    }

    private static UserEntity createTestUser() {
        return new UserEntity()
                .setUsername("username")
                .setEmail("test@example.com")
                .setActive(true)
                .setPassword("password")
                .setRoles(List.of(
                        new RolesEntity().setRole(RolesEnum.ADMIN),
                        new RolesEntity().setRole(RolesEnum.USER)
                ));
    }
}
