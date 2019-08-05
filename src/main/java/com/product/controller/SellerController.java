package com.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.product.dao.*;
import com.product.details.CartDetails;
import com.product.details.ProductDetails;
import com.product.model.*;


@RestController
public class SellerController {
	@Autowired
	private OrderDAO oDao;
	@Autowired
	private ProductDAO productDao;
	@Autowired
	private DealDAO dealDao;
	@GetMapping(path="/{sellername}/sellorders", produces = "application/json")
	public List<Order> getAllOrderBySellerName(@PathVariable("sellername") String sellername) 
	{
		 return oDao.getAllOrderBySellerName(sellername);
	}
	@GetMapping(path="/searchcartseller/{sellername}", produces = "application/json")
	public List<Object> searchCartSeller(@PathVariable("sellername") String sellername) 
	{
		List<Object> list = new ArrayList<>();
		List<ProductDetails> productDetailsList=new ArrayList<>();
		 List<Order> orderList = oDao.getAllOrderBySellerName(sellername);
		 double totalPrice=0.0;
		 int totalDCharge=0;
		 for(int i=0;i<orderList.size();i++)
		 {
			 Product p = productDao.getProduct(orderList.get(i).getProductId());
			 int quantity=orderList.get(i).getQuantity();
			 double price=p.getPrice();
			 Deal d= dealDao.getDealByCategory(p.getCategory());
			 int discount=0;
			 if(d!=null)
				 discount=d.getDiscount();
			 
			 double cartPrice=price-(price*discount/100);
			 totalDCharge+=p.getdCharge();
			 totalPrice+=quantity*cartPrice;
			 productDetailsList.add(new ProductDetails(p.getProductName(),p.getProductID(),0, p.getCategory(), p.getSellerName(),price, p.getdCharge(),
					 quantity, quantity*cartPrice, cartPrice)); 	
		 }
		 CartDetails cartDetails=new CartDetails(productDetailsList,totalPrice,totalDCharge,totalPrice+totalDCharge);
		 System.out.println("cartDetails:"+cartDetails);
		 list.add(cartDetails);
		 return list;

	}

}
