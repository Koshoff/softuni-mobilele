package com.example.mobilele.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/*
След като клиента се логне и го идентифицираме се генерира session id.Това id
сочи към този session bean
 */

@Component("currentUser")
@SessionScope
public class CurrentUser {

    private String firstName;
    private String lastName;
    private boolean isLogged;

    public String getFirstName() {
        return firstName;
    }

    public CurrentUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CurrentUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public CurrentUser setLogged(boolean logged) {
        isLogged = logged;
        return this;
    }

    public void logOut(){
        setLogged(false);
        setLastName(null);
        setFirstName(null);
    }

    public String getFullName(){
        StringBuilder sb = new StringBuilder();
        if(firstName != null){
            sb.append(firstName);
            sb.append(" ");
        }
        if(lastName != null){
            sb.append(lastName);
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return "CurrentUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isLogged=" + isLogged +
                '}';
    }
}
