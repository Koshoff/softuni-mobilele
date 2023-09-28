package com.example.mobilele.service;

import com.example.mobilele.model.dto.UserLoginDTO;
import com.example.mobilele.model.dto.UserRegistrationDTO;

public interface UserService {

     void register(UserRegistrationDTO userRegistrationDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);

    void logoutUser();
}
