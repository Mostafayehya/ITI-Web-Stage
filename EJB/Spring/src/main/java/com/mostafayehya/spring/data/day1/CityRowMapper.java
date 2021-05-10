/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.spring.data.day1;

import com.mostafayehya.spring.data.day1.model.City;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author moust
 */
public class CityRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {

        City city = new City();
        city.setID(rs.getInt("ID"));
        city.setName(rs.getString("Name"));
        
        return city;
    }

}
