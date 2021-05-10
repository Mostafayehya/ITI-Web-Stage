/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.day2;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CustomerDaoImpl0 implements CustomerDao0 {

    private Session session;

    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }

    @Override
    public List<Customer> findAll() {
        String query = "FROM Customer c";
        return session.createQuery(query).list();
    }

    @Override
    public Customer save(Customer customer) {

        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        return customer;
    }

}
