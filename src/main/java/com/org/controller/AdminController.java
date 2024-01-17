package com.org.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.AdminDao;
import com.org.dto.Admin;
import com.org.utility.Helper;

@Controller
public class AdminController {
//	@Autowired
//	AdminDao dao;
//	public void save(@ModelAttribute Admin admin) {
//		List<Admin> list = dao.fetchAll();
//		
//	}
	
	@RequestMapping("/hello")
	public String m1() {
		EntityManagerFactory emf = Helper.getEMFactory();
		                   
		EntityManager em = emf.createEntityManager();
		
		System.out.println("success");
		
		return "RegisterMerchant.jsp";
	}
	
	
	@PostMapping("/login_admin")
	public ModelAndView loginAdmin(@RequestParam String email,@RequestParam String password,HttpSession session) {
		
		List<Admin> admins = new AdminDao().fetchByEmailAndPassword(email, password);
		
		if(admins.isEmpty()) {
			ModelAndView mav=new ModelAndView("LoginAdmin.jsp");
			mav.addObject("fail","Invalid mail or password");
			return mav;
		}
		
		session.setAttribute("adminObj", admins.get(0));
		
		ModelAndView mav = new ModelAndView("admin/admin_home.jsp");
		return mav;
		
	}
	
	
	@GetMapping("/view_merchantsbyadmin")
	public ModelAndView showMerchants() {
		ModelAndView mav=new ModelAndView("admin/view_merchants.jsp");
		return mav;
		
		
	}
	@GetMapping("/view_productsbyadmin")
	public ModelAndView showProducts() {
		ModelAndView mav=new ModelAndView("admin/view_products.jsp");
		return mav;
		
		
	}
	
	@GetMapping("/logoutadmin")
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("adminObj");
		ModelAndView mav=new ModelAndView("LoginAdmin.jsp");
		return mav;
		
	}
	
	
	
}
