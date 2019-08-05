package com.product.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.product.dao.*;
import com.product.details.*;
import com.product.model.*;
@RestController
public class CartController {
	@Autowired
	private CartDAO cartDao;
	@Autowired
	private ProductDAO productDao;
	@Autowired
	private DealDAO dealDAO;
	 @GetMapping(path="/{userId}/cart", produces = "application/json")
	public CartDetails getCartDetailsByUserId(@PathVariable int userId) 
	 {
		 List<ProductDetails> productDetailsList=new ArrayList<>();
		 List<CartItem> cartItemsList= cartDao.getCartItems(userId);
		 double totalPrice=0.0;
		 int totalDCharge=0;
		 for(int i=0;i<cartItemsList.size();i++)
		 {
			 Product p = productDao.getProduct(cartItemsList.get(i).getpId());
			 int quantity=cartItemsList.get(i).getQuantity();
			 double price=p.getPrice();
			 Deal d= dealDAO.getDealByCategory(p.getCategory());
			 int discount=0;
			 if(d!=null)
				 discount=d.getDiscount();
			 
			 double cartPrice=price-(price*discount/100);
			 totalDCharge+=p.getdCharge();
			 totalPrice+=quantity*cartPrice;
			 productDetailsList.add(new ProductDetails(p.getProductName(),p.getProductID(),cartItemsList.get(i).getKartItemid(), p.getCategory(), p.getSellerName(),price, p.getdCharge(),
					 quantity, quantity*cartPrice, cartPrice)); 	
		 }
		 CartDetails cartDetails=new CartDetails(productDetailsList,totalPrice,totalDCharge,totalPrice+totalDCharge);
		 System.out.println("cartDetails:"+cartDetails);
      return cartDetails;
  }
	 @GetMapping(path="/{userId}/cartcount", produces = "application/json")
	public String getCartCount(@PathVariable int userId) 
   {
		 int count;
		 List<CartItem> cartItemsList= cartDao.getCartItems(userId);
		 count=cartItemsList.size();
		 return "{cartcount:"+count+"}";
   }
   

}
