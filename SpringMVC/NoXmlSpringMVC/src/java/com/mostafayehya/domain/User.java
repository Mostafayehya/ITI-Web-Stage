/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.domain;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
   

/**
 *
 * @author moust
 */

public class User {

  
    @Size(min=3,max=50,message = "Your name must be 3 and 50")
    private String name;
    private Integer id;
    @Min(value=1200,message="Invalid Salary")
    private Double salary;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public User(String name, Integer id, Double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public User(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    

    public User(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

}
