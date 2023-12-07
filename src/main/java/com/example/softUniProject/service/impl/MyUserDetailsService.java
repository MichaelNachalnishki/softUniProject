package com.example.softUniProject.service.impl;

import com.example.softUniProject.model.Entity.RolesEntity;
import com.example.softUniProject.model.Entity.UserEntity;
import com.example.softUniProject.repo.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    public MyUserDetailsService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).map(MyUserDetailsService::map).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    private static UserDetails map(UserEntity userEntity){
       return User.withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(userEntity.getRoles().stream().map(MyUserDetailsService::map).toList()).build();
    }

    private static GrantedAuthority map(RolesEntity rolesEntity){
        return new SimpleGrantedAuthority("ROLE_" + rolesEntity.getRole().name());
    }
}
