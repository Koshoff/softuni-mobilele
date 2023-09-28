package com.example.mobilele.web;

import com.example.mobilele.model.dto.UserRegistrationDTO;
import com.example.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
public class UserRegistrationController {
    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(){
        return "auth-register";
    }

    @PostMapping("/register")
    /*
    Тук подаваме обекта от тип UserRegistrationDTO в пост заявката
    и когато клиента попълни данните , те ще се съхранят в този обект.
    Тук вместо обект от тип UserRegistrationDTO можем да използваме @RequestParam() и да изброим всичко.
     */
    public String register(UserRegistrationDTO userRegistrationDTO){
        userService.register(userRegistrationDTO);
        return "redirect:/";
    }


}
