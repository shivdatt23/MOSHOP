package com.org.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dto.Cart;
import com.org.dto.Items;
import com.org.utility.Helper;
@Component
public class ItemsDao {


	public List<Items> fetchAll(){
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select c from Items c");
		
		List<Items> list = query.getResultList();
		
		return list;
		
	}
	
	
	public Items fetchById(int id) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		return em.find(Items.class, id);	
	}


	public void saveAndUpdate(Cart cart) {
		
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(cart);
		et.commit();
		
	}
	
	
	
	public void removeItem(int itemId,int cartId) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Items item = em.find(Items.class, itemId);
		Cart cart = em.find(Cart.class, cartId);
		
		List<Items> items = cart.getItems();
		
		List<Items> items2=new ArrayList<Items>();
		
		for(Items i:items) {
			if(i.getId()!=itemId) items2.add(i);
		}
		
		cart.setItems(items2);
		
		et.begin();
		em.merge(cart);
		em.remove(item);
		et.commit();
	}
	
}
