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
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcCityDaoImplUsingNamedParameterJDBC implements JdbcCityNamedParameterDao {

    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterjdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.namedParameterjdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void insert(City city) {

        String sql = "insert into city (ID,Name,CountryCode,District,Population) values (:id, :name, :countryCode, :district, :population)";
 
        Map<String,Object> args = new HashMap<>();
               
        args.put("id",city.getID());
        args.put("name",city.getName());
        args.put("countryCode",city.getCountryCode());
        args.put("district",city.getDistrict());
        args.put("population",city.getPopulation());
        namedParameterjdbcTemplate.update(sql, args);

    }
  

    @Override
    public int count() {

        String sql = "select count(*) from city;";
        Map<String,Object> args = new HashMap<>();
        
        int count = namedParameterjdbcTemplate.queryForObject(sql,args, Integer.class);
        return count;

    }

  
    
    

}
