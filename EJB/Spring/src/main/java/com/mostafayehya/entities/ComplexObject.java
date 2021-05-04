/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.entities;

import java.util.List;
import java.util.Set;

/**
 *
 * @author moust
 */
public class ComplexObject {

    List<User> usersList;
    Set<User> usersSet;

    public ComplexObject(Set<User> usersSet) {
        this.usersSet = usersSet;
    }

    public Set<User> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(Set<User> usersSet) {
        this.usersSet = usersSet;
    }

    public ComplexObject(List<User> usersList, Set<User> usersSet) {
        this.usersList = usersList;
        this.usersSet = usersSet;
    }
    
    
    
    

    public ComplexObject(List<User> usersList) {
        this.usersList = usersList;
    }

    public ComplexObject() {
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }


    

    @Override
    public String toString() {
        String result = "";
        for (User item : usersList) {
            result += "\n";
            result += item.toString();
        }
        for (User item : usersSet) {
            result += "\n";
            result += item.toString();
        }
        return result;
    }
    
    public void print() {
        String result = "";
        for (User item : usersList) {
            System.out.println(item.toString());
        }
    }

}
