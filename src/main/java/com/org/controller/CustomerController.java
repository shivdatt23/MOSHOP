package com.org.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.AdminDao;
import com.org.dao.CustomerDao;
import com.org.dao.MerchantDao;
import com.org.dto.Admin;
import com.org.dto.Cart;
import com.org.dto.Customer;
import com.org.dto.Merchant;
import com.org.dto.Customer;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerDao dao;

	@PostMapping("/register_customer")
	public ModelAndView registerCustomer(@ModelAttribute Customer customer) {
		//how to add a customer as multiple merchant will be present
		Cart cart=new Cart();
		customer.setCart(cart);	
		cart.setCustomer(customer);
		dao.saveAndUpdate(customer);
		
	
	ModelAndView mav=new ModelAndView("RegisterCustomer.jsp");
	
	mav.addObject("success","Registration Successful");
		
		return mav;
	}
	
	@PostMapping("/login_customer")
	public ModelAndView loginCustomer(@RequestParam String email, @RequestParam String password,HttpSession session) {
		
		List<Customer> customers = dao.fetchByEmailAndPassword(email, password);
		
		if(customers.isEmpty()) {
			ModelAndView mav=new ModelAndView("LoginCustomer.jsp");
			mav.addObject("fail","Invalid mail or password");
			return mav;
		}
		
		session.setAttribute("customerObj", customers.get(0));
		
		ModelAndView mav = new ModelAndView("customer/customer_home.jsp");
		return mav;
		
		
	}
	
	
	@GetMapping("/view_productsbycustomer")
	public ModelAndView showProducts() {
		ModelAndView mav=new ModelAndView("customer/view_products.jsp");
		return mav;
	}
	
	
	
	
	
	@GetMapping("/view_productlowtohigh")
	public ModelAndView showProductslowtohigh() {
		ModelAndView mav=new ModelAndView("customer/view_product_low_to_high.jsp");
		return mav;
	}
	
	
	@GetMapping("/view_producthightolow")
	public ModelAndView showProductshightolow() {
		ModelAndView mav=new ModelAndView("customer/view_product_high_to_low.jsp");
		return mav;
	}
	
	@GetMapping("/logoutcustomer")
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("customerObj");
		ModelAndView mav=new ModelAndView("LoginCustomer.jsp");
		return mav;
		
	}
	
	
}
