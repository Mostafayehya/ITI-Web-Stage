/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.spring.data.day1.dao;

import com.mostafayehya.spring.data.day1.model.City;
import java.util.List;

/**
 *
 * @author moust
 */
public interface JdbcCityNamedParameterDao {
    
    void insert (City city);
    
    
    int count();
    

}
