package com.example.mobilele.service.impl;

import com.example.mobilele.model.dto.UserLoginDTO;
import com.example.mobilele.model.dto.UserRegistrationDTO;
import com.example.mobilele.model.entity.UserEntity;
import com.example.mobilele.repository.UserRepository;
import com.example.mobilele.service.UserService;
import com.example.mobilele.util.CurrentUser;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Currency;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void register(UserRegistrationDTO userRegistrationDTO) {


        userRepository.save(map(userRegistrationDTO));

        /*
        Не трябва да подаваме пълен обект в регистрацията ,защото паролат може да се отпечата
        в някой лог
         */
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {
        //вадим цялото entity от базата данни.
        var userEntity=userRepository.findByEmail(userLoginDTO.email())
                .orElse(null);

        boolean loginSuccess = false;
        if(userEntity != null){
            //вадим въведената парола
            String rawPassword = userLoginDTO.password();
            //вадим криптираната парола
            String encodedPassword = userEntity.getPassword();
            //сравняваме двете пароли с passwordEncoder
            loginSuccess = encodedPassword != null &&
                    passwordEncoder.matches(rawPassword, encodedPassword);
            //Сетваме данните на currentUser-a
            if(loginSuccess){
                currentUser
                        .setLogged(true)
                        .setFirstName(userEntity.getFirstName())
                        .setLastName(userEntity.getLastName());
            }
            else{
                currentUser.logOut();
            }

        }


        return loginSuccess;

    }

    @Override
    public void logoutUser() {
        currentUser.logOut();
    }


    private  UserEntity map(UserRegistrationDTO userRegistrationDTO){
        return new UserEntity()
                .setActive(true)
                .setFirstName(userRegistrationDTO.firstName())
                .setLastName(userRegistrationDTO.lastName())
                .setEmail(userRegistrationDTO.email())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.password()));

    }
}
