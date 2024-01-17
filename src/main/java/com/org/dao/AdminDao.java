package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dto.Admin;
import com.org.utility.Helper;

@Component
public class AdminDao {
	

	public List<Admin> fetchAll(){
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select a from Admin a");
		List<Admin> list = query.getResultList();
		return list;
	}
	
	public Admin fetchById(int id){
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		return em.find(Admin.class, id);
	}
	
	public List<Admin> fetchByEmailAndPassword(String email,String password){
		
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select s from Admin s where s.email=?1 and s.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
			
		List<Admin> list = query.getResultList();
		
		return list;	
	}
	
	
}
