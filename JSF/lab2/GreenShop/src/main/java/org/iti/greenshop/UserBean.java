/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.iti.greenshop;


import javax.faces.bean.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;


/**
 *
 * @author java-Eman
 */
@Named("myBean")
//@ManagedBean(name="myBean")
@SessionScoped
public class UserBean implements Serializable{
    String userName;
    String greeting;
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGreeting() {
        if(userName != null) return "Welcome "+userName;
        else
            return "";
       }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    

}
