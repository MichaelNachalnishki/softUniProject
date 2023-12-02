package com.example.softUniProject.service.impl;

import com.example.softUniProject.model.Entity.UserEntity;
import com.example.softUniProject.repo.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    public MyUserDetailsService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).map(this::map).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    private UserDetails map(UserEntity userEntity){
       return User.withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(List.of())
                .build();
    }
}
