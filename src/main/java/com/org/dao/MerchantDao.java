package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dto.Admin;
import com.org.dto.Merchant;
import com.org.utility.Helper;

@Component
public class MerchantDao {
	
	
	
	
	
	public List<Merchant> fetchAll(){
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select a from Merchant a");
		List<Merchant> list = query.getResultList();
		return list;
	}
	
	public Merchant fetchById(int id){
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		return em.find(Merchant.class, id);
	}
	
	public List<Merchant> fetchByEmailAndPassword(String email,String password){
		
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
			
		List<Merchant> list = query.getResultList();
		
		return list;	
	}
	
	
	
	public void saveAndUpdate(Merchant merchant) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Admin admin = merchant.getAdmin();
		
		et.begin();
		
		em.merge(admin);
		
		et.commit();
		
		
	}
	

	
}
