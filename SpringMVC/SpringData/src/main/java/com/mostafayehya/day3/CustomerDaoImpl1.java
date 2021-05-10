/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.day3;

import com.mostafayehya.day2.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class CustomerDaoImpl1 implements CustomerDao0 {

    @PersistenceContext
    private EntityManager entityManager;

 

    @Override
    public List<Customer> findAll() {
        String query = "FROM Customer c";

        return entityManager.createQuery(query).getResultList();
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {

        entityManager.persist(customer);
        return customer;
    }

}
