/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.day2;

import java.util.List;

/**
 *
 * @author moust
 */
public interface CustomerDao2 {

    List<Customer> findAll();

    Customer save(Customer customer);

}
