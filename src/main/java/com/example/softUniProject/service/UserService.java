package com.example.softUniProject.service;

import com.example.softUniProject.model.dto.UserLoginDto;
import com.example.softUniProject.model.dto.UserRegisterDto;

public interface UserService {

    boolean register(UserRegisterDto userRegisterDto);
    boolean login(UserLoginDto userLogInDto);
    void logout();
}
