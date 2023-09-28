package com.example.mobilele.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
/*
Тук инициализираме Beans , които ще ни помагат с проекта , но нямат място при
Controllers , Services или Entities;
 */
@Configuration
public class AppConfig {


    /*
    С помоща на този Bean използваме хешфункция за паролата на потребителя
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();

    }
}
