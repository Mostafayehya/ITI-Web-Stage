/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.spring.data.day1.model;

/**
 *
 * @author moust
 */
public class City {
    
    Integer ID;
    String Name;
    String CountryCode;
    String District; 
    String Population;

    public City() {
    }

    public City(int i, String name) {
        this.ID=i;
        this.Name=name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public String getPopulation() {
        return Population;
    }

    public void setPopulation(String Population) {
        this.Population = Population;
    }
    
    

    public City(Integer ID, String Name, String CountryCode, String District, String Population) {
        this.ID = ID;
        this.Name = Name;
        this.CountryCode = CountryCode;
        this.District = District;
        this.Population = Population;
    }
    
    
}
