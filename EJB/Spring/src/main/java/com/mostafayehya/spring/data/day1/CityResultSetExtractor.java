/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.spring.data.day1;

import com.mostafayehya.spring.data.day1.model.City;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author moust
 */
public class CityResultSetExtractor implements ResultSetExtractor<List<City>> {

    @Override
    public List<City> extractData(ResultSet rs) throws SQLException, DataAccessException {
        
        List<City> result = new ArrayList<>();
        
        while(rs.next()){
            City city = new City();
            city.setID(rs.getInt("ID"));
            city.setName(rs.getString("Name"));
            
            result.add(city);
        }
        
        return result;
        
        
    }
    
}
