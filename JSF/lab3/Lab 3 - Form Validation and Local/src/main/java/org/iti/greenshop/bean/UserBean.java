/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.iti.greenshop.bean;


import java.io.Serializable;
import java.util.Date;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;
import org.iti.greenshop.model.CreditCard;


/**
 *
 * @author java-Eman
 */
//@ManagedBean(value="myBean")



@Named("myBean")
@SessionScoped
public class UserBean implements Serializable{
    String greeting;
    String userName;
    String password;
    Date birthDate;
    String email;
    CreditCard creditCard;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }


    public String getGreeting() {
        if(userName != null) return "Welcome "+userName;
        else
            return "";
    }

    public void validateEmail(FacesContext context, UIComponent toValidate,
                              Object value) throws ValidatorException {

    }
    

}
