package com.example.softUniProject.service.impl;

import com.example.softUniProject.model.Entity.UserEntity;
import com.example.softUniProject.model.dto.UserLoginDto;
import com.example.softUniProject.model.dto.UserRegisterDto;
import com.example.softUniProject.repo.UserRepository;
import com.example.softUniProject.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean register(UserRegisterDto userRegisterDto) {
        if(!userRegisterDto.getPassword().equals(userRegisterDto.getPassword())){
            return false;
        }

        boolean existsByUsernameOrEmail = userRepository.existsByUsernameOrEmail(userRegisterDto.getUsername(), userRegisterDto.getEmail());

        if(existsByUsernameOrEmail){
            return false;
        }

        UserEntity user = new UserEntity();
        user.setUsername(userRegisterDto.getUsername());
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        user.setEmail(userRegisterDto.getEmail());

        userRepository.save(user);

        return true;
    }

    @Override
    public boolean login(UserLoginDto userLogInDto) {
        String username = userLogInDto.getUsername();

        UserEntity user = userRepository.findByUsername(username);

        if (user != null && passwordEncoder.matches(userLogInDto.getPassword(), user.getPassword())){
            loggedUser.login(username);
            return true;
        }

        return false;
    }

    @Override
    public void logout() {
        this.loggedUser.logout();
    }


}
