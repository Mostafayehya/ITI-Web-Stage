/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.spring.data.day1.dao;

import com.mostafayehya.spring.data.day1.CityResultSetExtractor;
import com.mostafayehya.spring.data.day1.CityRowMapper;
import com.mostafayehya.spring.data.day1.model.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcCityDaoImpUsingSimpleJDBCInsert implements JdbcCityNamedParameterDao {

    private DataSource dataSource;
    private SimpleJdbcInsert simpleJdbcInsert;

 

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("city").usingColumns("ID","Name","CountryCode","District","Population");
    }

    @Override
    public void insert(City city) {

        Object[] args = new Object[]{city.getID(), city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation()};
               Map<String,Object> parameters = new HashMap<>(); 
               parameters.put("ID",city.getID());
               parameters.put("Name", city.getName());
               parameters.put("CountryCode", city.getCountryCode());
               parameters.put("District", city.getDistrict());
               parameters.put("Population", city.getPopulation());
               

        simpleJdbcInsert.execute(parameters);

    }
  

    @Override
    public int count() {

    
        return 0;

    }

  
    
    

}
