package com.example.mobilele.model.entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import org.apache.catalina.User;


@Entity
@Table(name="user")
public class UserEntity extends BaseEntity{
    @Column(unique = true)
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;



    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
                return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserEntity setActive(boolean active) {
        isActive = active;
        return this;
    }
}
