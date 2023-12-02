package com.example.softUniProject.service.impl;

import com.example.softUniProject.model.Entity.UserEntity;
import com.example.softUniProject.model.dto.UserRegisterDto;
import com.example.softUniProject.repo.UserRepository;
import com.example.softUniProject.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
    userRepository.save(map(userRegisterDto));
    }

    private UserEntity map(UserRegisterDto userRegisterDto) {
        return new UserEntity().setActive(true)
                .setEmail(userRegisterDto.getEmail())
                .setUsername(userRegisterDto.getUsername())
                .setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

    }



}
