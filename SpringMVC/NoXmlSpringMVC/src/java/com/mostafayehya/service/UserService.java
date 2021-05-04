/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.service;

import com.mostafayehya.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author moust
 */
@Component
public class UserService {

    List<User> users;

    public UserService() {
        this.users = new ArrayList<>();

        users.add(new User("mostafa", 1));
        users.add(new User("yehya", 2));
        users.add(new User("mansour", 3));
        users.add(new User("ahmed", 4));
        users.add(new User("metwally", 5));

    }

    public List<User> getAllUsers() {

        return users;
    }

    public User getUser(Integer id) {

        User result = users.stream()
                .filter(user -> id == user.getId())
                .findAny()
                .orElse(null);

        return result;
    }

    public void addUser(User user) {
       
        users.add(user);
                
                
    }



}
