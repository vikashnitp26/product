package com.product.dao;

import java.util.List;
import java.util.Set;

import com.product.model.Order;

public interface OrderDAO {
	
	public List<Order> getAllOrder();
	public void addOrder(Order newOrder);
	public void removeOrder(int p_id);
	public Set<String> getCategoryByUserId(int userId);
	public List<Order> getAllOrderByUserId(int userId);
	public List<Order> getAllOrderBySellerName(String sellerName);
	public boolean cancelOrder(int userId,int orderId);
}
