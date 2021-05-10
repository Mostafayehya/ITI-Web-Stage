/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.day2;

import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class CustomerDaoImpl3 implements CustomerDao3 {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<Customer> findAll() {
        String query = "FROM Customer c";

        return (List<Customer>) hibernateTemplate.find(query);
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {

        hibernateTemplate.save(customer);

        return customer;
    }

}
