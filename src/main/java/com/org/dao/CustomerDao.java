package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dto.Customer;
import com.org.utility.Helper;

@Component
public class CustomerDao {

	public List<Customer> fetchAll(){
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select c from Customer c");
		
		List<Customer> list = query.getResultList();
		
		return list;
		
	}
	
	
	public Customer fetchById(int id) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		return em.find(Customer.class, id);	
	}
	
	
	public List<Customer> fetchByEmailAndPassword(String email,String password){
		
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select c from Customer c where c.email=?1 and c.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Customer> list = query.getResultList();
		
		return list;	
	}
	
	public void saveAndUpdate(Customer customer) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(customer);
		et.commit();
	}
	
	
	
	
}
