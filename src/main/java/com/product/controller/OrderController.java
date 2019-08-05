package com.product.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.product.dao.OrderDAO;
import com.product.dao.ProductDAO;
import com.product.details.Recommendation;
import com.product.model.Order;
import com.product.model.Product;


@RestController
public class OrderController {
	
	@Autowired
	private OrderDAO orderDao;
	@Autowired
	private ProductDAO pDao;
	@GetMapping(path="{userid}/recommendations", produces = "application/json")
	public List<Recommendation> getRecommendations(@PathVariable("userid") int userId) 
	{
		Set<String> setCat=orderDao.getCategoryByUserId(userId);
		Iterator itr=setCat.iterator();
		List<Recommendation> listRec=new ArrayList<>();
		int count=0;
		while(itr.hasNext())
		{
			List<Product> pList=pDao.getProductByCategory((String)itr.next());
			for(int j=0;j<pList.size();j++)
			{
				Recommendation r=new Recommendation();
				r.category=pList.get(j).getCategory();
				r.displayName=pList.get(j).getProductName();
				r.shortDesc=pList.get(j).getProductDesc();
				listRec.add(r);
				count++;
			}
			if(count>15)
				break;
		}
		return listRec;
	}
	@GetMapping(path="{userid}/orders", produces = "application/json")
	public List<Order> getOrdersByUserId(@PathVariable("userid") int userId) 
	{		
		return orderDao.getAllOrderByUserId(userId);
	}
	@GetMapping(path="{userid}/orders/{orderId}/cancel", produces = "application/json")
	public String cancelOrder(@PathVariable("userid") int userId,@PathVariable("orderId") int orderId) 
	{		
		 if(orderDao.cancelOrder(userId,orderId))
			 return "cancelled";
		 else
			 return "no order found";
	}
	@GetMapping(path="{userid}/orders/{orderId}/return", produces = "application/json")
	public String returnOrder(@PathVariable("userid") int userId,@PathVariable("orderId") int orderId) 
	{		
		 if(orderDao.cancelOrder(userId,orderId))
			 return "returned";
		 else
			 return "no order found";
	}
	@GetMapping(path="{userid}/orders/{orderId}/deliver", produces = "application/json")
	public String deliverOrder(@PathVariable("userid") int userId,@PathVariable("orderId") int orderId) 
	{		
		 if(orderDao.cancelOrder(userId,orderId))
			 return "delivered";
		 else
			 return "no order found";
	}
	
}
