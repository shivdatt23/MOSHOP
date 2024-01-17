package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.org.dto.Admin;
import com.org.dto.Merchant;
import com.org.dto.Product;
import com.org.utility.Helper;
@Component
public class ProductDao {


	public List<Product> fetchAll(){
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select c from Product c");
		
		List<Product> list = query.getResultList();
		
		return list;
		
	}
	
	
	public Product fetchById(int id) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		return em.find(Product.class, id);	
	}
	
	public void saveAndUpdate(Product product) {
		
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		
		
		
		et.begin();
		
		em.merge(product);
		
		et.commit();
		
	}
	
	
	public List<Product> fetchByLowToHigh(){
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		Query query=em.createQuery("select p from Product p order by p.price asc");
		
		List<Product> list = query.getResultList();
		
		return list;
		
		
		
	}
	
	
	public List<Product> fetchByHighToLow(){
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		Query query=em.createQuery("select p from Product p order by p.price desc");
		
		List<Product> list = query.getResultList();
		
		return list;
		
		
		
	}
	
	
}
