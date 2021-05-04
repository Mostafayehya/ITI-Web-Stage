/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iti.greenshop;


import java.io.Serializable;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

/**
 *
 * @author ITI
 */
@Named("userReg")
@SessionScoped
public class UserReg implements Serializable {

    private String name;
    private String password;
    private String birthdate;
    private String email;
//    @Inject
    private CreditCard creditCardNumber;

    public CreditCard getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(CreditCard creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
