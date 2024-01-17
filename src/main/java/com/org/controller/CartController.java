package com.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

	@GetMapping("/view_cart")
	public ModelAndView viewCart() {
		ModelAndView mav=new ModelAndView("customer/view_cart.jsp");
		return mav;
	}
}
