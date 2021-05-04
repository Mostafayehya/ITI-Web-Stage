/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.iti.greenshop;


import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;


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
