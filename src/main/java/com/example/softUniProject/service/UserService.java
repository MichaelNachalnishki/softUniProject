package com.example.softUniProject.service;

import com.example.softUniProject.model.dto.UserRegisterDto;

public interface UserService {

    void registerUser(UserRegisterDto userRegisterDto);

    boolean containsEmail(String email);


}
