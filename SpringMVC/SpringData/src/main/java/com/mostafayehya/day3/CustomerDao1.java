/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.day3;

import com.mostafayehya.day2.Customer;
import java.util.List;

/**
 *
 * @author moust
 */
public interface CustomerDao1 {


    List<Customer> findAll();

    Customer save(Customer customer);


}
