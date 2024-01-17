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
import com.org.dao.MerchantDao;
import com.org.dto.Admin;
import com.org.dto.Merchant;

@Controller
public class MerchantController {
	
	@PostMapping("/register_merchant")
	public ModelAndView registerMerchant(@ModelAttribute Merchant merchant) {
		
		
		List<Merchant> merchants=new ArrayList<Merchant>();
		
		merchants.add(merchant);
		Admin admin=new AdminDao().fetchById(1);
		merchant.setAdmin(admin);
		admin.setMerchant(merchants);
		
	new MerchantDao().saveAndUpdate(merchant);
	
	ModelAndView mav=new ModelAndView("RegisterMerchant.jsp");
	
	mav.addObject("success","Registration Successful");
		
		return mav;
	}
	
	@PostMapping("/login_merchant")
	public ModelAndView loginMerchant(@RequestParam String email, @RequestParam String password,HttpSession session) {
		
		List<Merchant> merchants = new MerchantDao().fetchByEmailAndPassword(email, password);
		
		if(merchants.isEmpty()) {
			ModelAndView mav=new ModelAndView("LoginMerchant.jsp");
			mav.addObject("fail","Invalid mail or password");
			return mav;
		}
		
		session.setAttribute("merchantObj", merchants.get(0));
		session.setAttribute("id", merchants.get(0).getId());
		
		ModelAndView mav = new ModelAndView("merchant/merchant_home.jsp");
		return mav;
		
		
	}
	
	@GetMapping("/view_products")
	public ModelAndView showProducts() {
		
		ModelAndView mav=new ModelAndView("merchant/view_products.jsp");
		
		return mav;
		
		
	}
	
	
	@GetMapping("/logoutmerchant")
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("merchantObj");
		session.removeAttribute("id");
		ModelAndView mav=new ModelAndView("LoginMerchant.jsp");
		return mav;
		
	}
	
	
	
}
