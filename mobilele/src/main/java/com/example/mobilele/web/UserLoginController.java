package com.example.mobilele.web;

import com.example.mobilele.model.dto.UserLoginDTO;
import com.example.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login(){
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginDTO userLoginDTO){
        boolean loginSuccessful = userService.loginUser(userLoginDTO);

        return loginSuccessful ? "index" : "auth-login";

        }

    @GetMapping("/users/logout")
    public String logOut(){
        userService.logoutUser();
        return "index";
    }






}
