package com.example.mobilele.model.dto;
/*
В html auth-register формата имаме поле за попълване с дадено име
firstName , тук в този record параметъра трябва да е със същото име, за да
работят нещата.
 */
public record UserRegistrationDTO(String firstName,
                                  String lastName,
                                  String email,
                                  String password,
                                  String passwordConfirmation) {
}
