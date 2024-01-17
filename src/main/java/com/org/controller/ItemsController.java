package com.org.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.CartDao;
import com.org.dao.ItemsDao;
import com.org.dao.ProductDao;
import com.org.dto.Cart;
import com.org.dto.Customer;
import com.org.dto.Items;
import com.org.dto.Product;

@Controller
public class ItemsController {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ItemsDao itemsDao;
	
	@GetMapping("/add_to_cart")
	public ModelAndView saveAndUpdate(@RequestParam int productId,HttpSession session) {
		
		Product product = productDao.fetchById(productId);
		
		Items item=new Items();
		
		item.setId(product.getId());
		item.setName(product.getName());
		item.setCategory(product.getCategory());
		item.setPrice(product.getPrice());
		item.setStockLeft(product.getStockLeft());
		
		
		Customer customer = (Customer)session.getAttribute("customerObj");
		
		Cart cart = customer.getCart();
				
		List<Items> items = cart.getItems();
		
		items.add(item);
		
		cart.setItems(items);
		item.setCart(cart);
		
		
		itemsDao.saveAndUpdate(cart); 
		
		session.setAttribute("added", "product added to cart");
		
		
		
		ModelAndView mav=new ModelAndView("customer/view_products.jsp");
		return mav;
	}
	
	
	
	@GetMapping("/remove_item")
	public ModelAndView removeItem(@RequestParam int itemId,HttpSession session) {
		
		Customer customer = (Customer)session.getAttribute("customerObj");
		int cartId = customer.getCart().getId();
	
		itemsDao.removeItem(itemId, cartId);
		
		ModelAndView mav=new ModelAndView("customer/view_cart.jsp");
		return mav;
	}

}
