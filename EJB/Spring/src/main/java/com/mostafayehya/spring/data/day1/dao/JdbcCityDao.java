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
public interface JdbcCityDao {
    
    void insert (City city);
    
    City findCityById(int cityId);
    
    List<City> getAllCities();
    List<City> getAllCitiesByResultSetExtractor();
    List<City> getAllCitiesByBeanPropertyMapper();
    List<City> getAllCitiesByCityRowMapper();
    
    int count();
    
    int countByPopulationLessThan( int population);
    
    City findCityByIdUsingJDBCTemplate(int cityId);
    
    City findCityByIdUsingBeanPropertyRowMapper(int cityId);
    
    City findCityByIdUsingRowMapperClass(int cityId);
    
    void updateCity(City city);
    
    void deleteCity(City city);
    
    void createNamesTable();
}
