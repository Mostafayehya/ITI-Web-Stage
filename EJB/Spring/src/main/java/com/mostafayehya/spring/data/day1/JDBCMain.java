/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.spring.data.day1;

import com.mostafayehya.spring.data.day1.dao.JdbcCityDao;
import com.mostafayehya.spring.data.day1.dao.JdbcCityDaoImpUsingSimpleJDBCInsert;
import com.mostafayehya.spring.data.day1.dao.JdbcCityNamedParameterDao;
import com.mostafayehya.spring.data.day1.model.City;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moust
 */
public class JDBCMain {

    public static void main(String[] args) {

//        ApplicationContext context
//                = new ClassPathXmlApplicationContext("spring/data/day1/beans.xml");
        ApplicationContext context
                = new ClassPathXmlApplicationContext("aop/day2/beans_1.xml");

        JdbcCityDao cityDao = (JdbcCityDao) context.getBean("cityDao");
        City city = cityDao.findCityById(2);
        System.out.println("Fetched City name =" + city.getName());

        System.out.println("\n====================Testing JDBC template====================");

        System.out.println(" number of city rows in city table = " + cityDao.count());
        System.out.println(" number of citities with population less than 1000 = " + cityDao.countByPopulationLessThan(1000));
        System.out.println(" find city by id using JDBCtemplate = " + cityDao.findCityByIdUsingJDBCTemplate(5).getName());
        System.out.println(" find city by id using BeanPropertyRowMapper = " + cityDao.findCityByIdUsingBeanPropertyRowMapper(10).getName());
        System.out.println(" find city by id using CustomerRowMapper = " + cityDao.findCityByIdUsingRowMapperClass(20).getName());
        System.out.println("\n\nAll Cities = ");
//        cityDao.getAllCities().stream().forEach(c->{System.out.println("ID: "+c.getID()+"    City Name: "+c.getName());});
//        cityDao.getAllCitiesByResultSetExtractor().stream().forEach(c->{System.out.println("ID: "+c.getID()+"    Name: "+c.getName());});
//        cityDao.getAllCitiesByBeanPropertyMapper().stream().forEach(c->{System.out.println("ID: "+c.getID()+"    Name: "+c.getName());});
//        cityDao.getAllCitiesByCityRowMapper().stream().forEach(c->{System.out.println("ID: "+c.getID()+"    Name: "+c.getName());});

        //  System.out.println("Insert City of 44444 lala land ");
        //   cityDao.insert(new City(4444, "LALA LAND", "USA", "LALA District", "1"));
        System.out.println("update first record to be Awlad Sakr, AWS as country code ");
        City toUpdate = new City();
        toUpdate.setID(1);
        toUpdate.setName("Awlad sakr");
        toUpdate.setCountryCode("AWS");
        cityDao.updateCity(toUpdate);

        System.out.println("Deleting first city");
        //  cityDao.deleteCity(city);

        System.out.println("Creating Names Table");
        //  cityDao.createNamesTable();

        System.out.println("\n====================Testing Named paramter JDBC template====================");

        JdbcCityNamedParameterDao cityNamedParamterDao = (JdbcCityNamedParameterDao) context.getBean("cityNamedParamterDao");

        System.out.println("Insert City of 44444 lala land ");
        //cityNamedParamterDao.insert(new City(666666666, "LALA LAND", "USA", "LALA District", "1"));

        System.out.println(" number of city rows in city table using Named paramters = " + cityNamedParamterDao.count());

        System.out.println("\n====================Testing JDBCDao Support template====================");

        JdbcCityNamedParameterDao cityDaoSupport = (JdbcCityNamedParameterDao) context.getBean("cityDaoWithDaoSupport");

        System.out.println("Insert City of 44444 lala land ");
  //      cityDaoSupport.insert(new City(5000, "LALA LAND", "USA", "LALA District", "1"));

        System.out.println("Count using JDBCDaoSupport = " + cityDaoSupport.count());

        System.out.println("\n====================Testing Simple JDBC Insert ====================");

        JdbcCityDaoImpUsingSimpleJDBCInsert simpleJdbcInsert = (JdbcCityDaoImpUsingSimpleJDBCInsert) context.getBean("cityDaoJdbcInsert");

        simpleJdbcInsert.insert(new City(5001, "New City", "USA", "LALA District", "1"));

    }
}
