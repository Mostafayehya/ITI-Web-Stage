/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.day4;

import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author moust
 */
public interface CustomerCrudRepository extends CrudRepository<Customer,Integer> {
    
    int countByNameAndAge(String name,int Age);
    
    int countByName(String name);
    
    List<Customer> findCustomerByIdGreaterThan(int id);
    List<Customer> findDistinctCustomerByAge(int age);
    List<Customer> findByNameIgnoreCase(String name);
    List<Customer> findByNameOrderByNameAsc(String name);
    List<Customer> findByNameOrderByNameDesc(String name);
    List<Customer> findByAgeOrderByAgeDesc(int age);
    
    
    @Query(value="select * from customer c where name=?1 ",
            nativeQuery = true)
    List<Customer> findByNameNavtive(String name);
    
  
    @Transactional
    @Modifying
    @Query("update Customer c  set name=?2, age=?1 where id=?3")
    void updateCustomer(int age,String name,int id);
    
}
