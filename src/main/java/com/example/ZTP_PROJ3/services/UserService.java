package com.example.ZTP_PROJ3.services;

import com.example.ZTP_PROJ3.beans.Role;
import com.example.ZTP_PROJ3.beans.User;
import com.example.ZTP_PROJ3.exceptions.NotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.HashMap;


@Service
public class UserService {

    HashMap<String, String> Users = new HashMap<>();

    public UserService(){
        //Przykładowi użytkownicy
        Users.put("admin", "admin123");
        Users.put("czytelnik11","czyt0077");
        Users.put("czytelnik12","czesc1234");
        Users.put("czytelnik13","omen991");
        Users.put("czytelnik14","Siek1122");
    }

    public User getUserByLogin(String login) {
        if (Users.get(login) == null) {
            return null;
        } else if ("admin".equals(login)) {
            return new User(User.idCreator(), login, Users.get(login), Role.ADMIN);
        } else {
            return new User(User.idCreator(), login, Users.get(login), Role.USER);
        }
    }
}
