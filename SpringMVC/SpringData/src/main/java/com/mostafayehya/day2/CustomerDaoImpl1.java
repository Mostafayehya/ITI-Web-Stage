/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.day2;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class CustomerDaoImpl1 implements CustomerDao1 {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<Customer> findAll() {
        String query = "FROM Customer c";

       return (List<Customer>) hibernateTemplate.find(query);
    }

    @Override
    public Customer save(Customer customer) {
        
       // Doesn't work as autocommit isn't available by default
      //  hibernateTemplate.save(customer);
        
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session sn) throws HibernateException {
                sn.beginTransaction();
                sn.save(customer);
                sn.getTransaction().commit();
                return null;
            }
        });
        
        return customer;
    }

}
