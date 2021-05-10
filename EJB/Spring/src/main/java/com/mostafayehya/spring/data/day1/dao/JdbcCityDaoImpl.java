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
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcCityDaoImpl implements JdbcCityDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(City city) {

        String sql = "insert into city (ID,Name,CountryCode,District,Population) values (?,?,?,?,?)";
        Object[] args = new Object[]{city.getID(), city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation()};

        jdbcTemplate.update(sql, args);

    }

    @Override
    public City findCityById(int cityId) {
        String sql = "select * from city where id= ?";
        Connection connection = null;
        City city = null;

        try {

            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            preparedStatement.setInt(1, cityId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                city = new City();
                city.setID(resultSet.getInt("ID"));
                city.setName(resultSet.getString("Name"));
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            Logger.getLogger(JdbcCityDaoImpl.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JdbcCityDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return city;
    }

    @Override
    public City findCityByIdUsingJDBCTemplate(int cityId) {
        String sql = "select * from city where id= ?";

        Object[] args = new Object[]{cityId};
        SqlRowSet rowset = jdbcTemplate.queryForRowSet(sql, args);
        City city = null;

        if (rowset.next()) {
            city = new City();

            city.setID(rowset.getInt("ID"));
            city.setName(rowset.getString("Name"));

        }

        return city;
    }

    @Override
    public List<City> getAllCities() {
        String sql = "select * from city";
        List<City> cities = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map row : rows) {
            City city = new City();
            city.setID((Integer) row.get("ID"));
            city.setName((String) row.get("Name"));

            cities.add(city);
        }

        return cities;

    }

    @Override
    public List<City> getAllCitiesByResultSetExtractor() {

        String sql = "select * from city";
        List<City> cities = new ArrayList<>();
        cities = jdbcTemplate.query(sql, new CityResultSetExtractor());
        return cities;

    }

    @Override
    public List<City> getAllCitiesByBeanPropertyMapper() {

        String sql = "select * from city";
        List<City> cities = new ArrayList<>();
        cities = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(City.class));
        return cities;

    }

    @Override
    public List<City> getAllCitiesByCityRowMapper() {

        String sql = "select * from city";
        List<City> cities = new ArrayList<>();
        cities = jdbcTemplate.query(sql, new CityRowMapper());
        return cities;

    }

    @Override
    public int count() {

        String sql = "select count(*) from city;";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;

    }

    @Override
    public int countByPopulationLessThan(int population) {

        String sql = "select count(*) from city where Population < ?";
        int rowCount = jdbcTemplate.queryForObject(sql, new Object[]{population}, Integer.class);
        return rowCount;

    }

    @Override
    public City findCityByIdUsingBeanPropertyRowMapper(int cityId) {

        String sql = "select * from city where id= ?";

        Object[] args = new Object[]{cityId};
        City city = jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<>(City.class));

        return city;

    }

    @Override
    public City findCityByIdUsingRowMapperClass(int cityId) {

        String sql = "select * from city where id= ?";

        Object[] args = new Object[]{cityId};
        City city = (City) jdbcTemplate.queryForObject(sql, args, new CityRowMapper());

        return city;

    }

    @Override
    public void updateCity(City city) {

        String sql = "update city set Name=? where id=?";
        Object[] args =new Object[]{city.getName(),city.getID()};
        
        jdbcTemplate.update(sql,args);
    }

    @Override
    public void deleteCity(City city) {
        
        String  sql = "delete from city where id=?";
        
        Object[] args = new Object[]{city.getID()};
        
        jdbcTemplate.update(sql,args);
    }

    @Override
    public void createNamesTable() {
       
        String sql = "create table names (id integer, name varchar(100))";
        jdbcTemplate.execute(sql);
    }
    
    
    
    

}
