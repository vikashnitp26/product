package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import com.product.dao.ProductDAO;
import com.product.model.*;

@RestController
public class ProductController {
    
	@Autowired
	private ProductDAO productDao;
	 @GetMapping(path="/searchproduct", produces = "application/json")
	public List<Product> getAllProduct() 
   {
       return productDao.getAllProducts();
   }
   @GetMapping(path="/searchproduct/{pValue}", produces = "application/json")
   public List<Product> getProduct(@PathVariable("pValue") String pValue) 
   {
       return productDao.getProductLikeName(pValue);
   }
   @GetMapping(path="/{pname}/details", produces = "application/json")
   public String getProductDetails(@PathVariable("pname") String pname) 
   {
       return productDao.getProductByName(pname).getProductDesc();
   }
   
}
