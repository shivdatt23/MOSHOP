package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dto.Cart;
import com.org.dto.Items;
import com.org.utility.Helper;

@Component
public class CartDao {


	public List<Cart> fetchAll(){
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select c from Cart c");
		
		List<Cart> list = query.getResultList();
		
		return list;
		
	}
	
	
	public Cart fetchById(int id) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		return em.find(Cart.class, id);	
	}
	
	
	
}
