package com.example.ZTP_PROJ3.beans;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public class User {
    public String id;
    public String login;
    public String pass;
    public final Role role;

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
        this.role = Role.USER;
    }
    public User(String login, String pass, Role role) {
        this.login = login;
        this.pass = pass;
        this.role = role;
    }
    public User(String id, String login, String pass, Role role) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.role = role;
    }


    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public Role getRole() {
        return role;
    }

    public static String idCreator() {
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID;
    }
}