package com.example.softUniProject.service.impl;

import com.example.softUniProject.events.UserRegistrationEvent;
import com.example.softUniProject.model.Entity.UserEntity;
import com.example.softUniProject.model.dto.UserRegisterDto;
import com.example.softUniProject.repo.UserRepository;
import com.example.softUniProject.service.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher applicationEventPublisher;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ApplicationEventPublisher applicationEventPublisher) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
    userRepository.save(map(userRegisterDto));

    applicationEventPublisher.publishEvent(new UserRegistrationEvent("UserService", userRegisterDto.getEmail(), userRegisterDto.getUsername()));
    }

    private UserEntity map(UserRegisterDto userRegisterDto) {
        return new UserEntity().setActive(false)
                .setEmail(userRegisterDto.getEmail())
                .setUsername(userRegisterDto.getUsername())
                .setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

    }



}
