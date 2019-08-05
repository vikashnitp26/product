package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.product.dao.ProductDAO;
import com.product.dao.DealDAO;
import com.product.model.Product;
import com.product.model.Deal;

@RestController
public class DealController {
    
	@Autowired
	private DealDAO dealDao;
	 @GetMapping(path="/deals", produces = "application/json")
	public List<Deal> getAllDeal() 
   {
       return dealDao.getAllDeals();
   }
  
}
