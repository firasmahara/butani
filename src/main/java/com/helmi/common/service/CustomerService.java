package com.helmi.common.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.helmi.common.entity.Customer;

@Stateless
public class CustomerService {

	@PersistenceContext
    EntityManager em;
 
    public void create(Customer entity) {
        em.persist(entity);
    }
 
    public void update(Customer entity) {
        em.merge(entity);
    }
 
    public void remove(long id) {
        Customer customer = find(id);
        em.remove(customer);
    }
 
    public Customer find(long id) {
        return em.find(Customer.class, id);
    }

}
