package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.MerchantDao;
import com.org.dao.ProductDao;
import com.org.dto.Merchant;
import com.org.dto.Product;


@Controller
public class ProductController {
	
	@Autowired
	MerchantDao merchantDao;
	
	@Autowired
	ProductDao productDao;
	
	@GetMapping("/add_product")
	public ModelAndView goToProduct() {
		
	ModelAndView mav=new ModelAndView("product/AddProduct.jsp");
	
	return mav;
	}
	
	
	
	
	
	@PostMapping("/register_product")
	public ModelAndView addProduct(@ModelAttribute Product product,@RequestParam int mid ) {
		
		Merchant merchant = merchantDao.fetchById(mid);
		
		List<Product> products = merchant.getProduct();
		
		products.add(product);
		
		merchant.setProduct(products);
		
		product.setMerchant(merchant);
		
		productDao.saveAndUpdate(product);
		
		ModelAndView mav = new ModelAndView("product/AddProduct.jsp");
		mav.addObject("success","Product Added");
		
		return mav;
		
		
		
	}

}
