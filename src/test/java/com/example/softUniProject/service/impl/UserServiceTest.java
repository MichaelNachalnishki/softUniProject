package com.example.softUniProject.service.impl;

import com.example.softUniProject.events.UserRegistrationEvent;
import com.example.softUniProject.model.Entity.UserEntity;
import com.example.softUniProject.model.dto.UserRegisterDto;
import com.example.softUniProject.repo.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private ApplicationEventPublisher applicationEventPublisher;

    @InjectMocks
    private UserServiceImpl userService;

    @Captor
    private ArgumentCaptor<UserEntity> userEntityCaptor;

    @Test
    public void testRegisterUser() {
        // Given
        UserRegisterDto userRegisterDto = new UserRegisterDto();

        userRegisterDto.setEmail("test@example.com");
        userRegisterDto.setUsername("testUser");

        // When
        userService.registerUser(userRegisterDto);

        // Then
        verify(userRepository).save(userEntityCaptor.capture());
        UserEntity capturedUserEntity = userEntityCaptor.getValue();

        // Assert that the UserRepository.save method was called with the correct UserEntity
        Assertions.assertEquals("test@example.com", capturedUserEntity.getEmail());
        Assertions.assertEquals("testUser", capturedUserEntity.getUsername());
        // You may want to use a library like AssertJ for more expressive assertions.

        // Verify that the ApplicationEventPublisher.publishEvent method was called with the correct event
        verify(applicationEventPublisher).publishEvent(any(UserRegistrationEvent.class));
    }

}
