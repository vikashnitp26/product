package com.product.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.product.dao.OrderDAO;
import com.product.model.CartItem;
import com.product.model.Order;
import com.product.model.Product;

public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	public List<Order> list = new ArrayList<Order>();

	
	public OrderDAOImpl() {
		
	}

	public OrderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Criteria criteria = s.createCriteria(Order.class);
		List<Order> list;
		list = criteria.list();
		tx.commit();
		s.close();
		System.out.println("Products Fetched");
		return list;
	}
	public List<Order> getAllOrderByUserId(int userId) {
		// TODO Auto-generated method stub
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Criteria criteria = s.createCriteria(Order.class);		
		List<Order> list = criteria.add(Restrictions.eq("userId", userId)).list();
		tx.commit();
		s.close();
		System.out.println("Orders Fetched");
		return list;
	}
	public List<Order> getAllOrderBySellerName(String sellerName) {
		// TODO Auto-generated method stub
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Criteria criteria = s.createCriteria(Order.class);		
		List<Order> list = criteria.add(Restrictions.eq("s_name", sellerName)).list();
		tx.commit();
		s.close();
		System.out.println("Orders Fetched");
		return list;
	}
	public void addOrder(Order newOrder) {
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		System.out.println("Inside OrderDAO"+newOrder);
//		s.save(newProduct);
		s.saveOrUpdate(newOrder);
		tx.commit();
		s.close();
		System.out.println("Order inserted");	

	}
	public void removeOrder(int d_id) {
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Order Order ;
		Order = (Order)s.load(Order.class,d_id);
		s.delete(Order);
		tx.commit();
		s.close();
		System.out.println("Order Deleted");
		
	}
	public Set<String> getCategoryByUserId(int userId){
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Criteria criteria = s.createCriteria(Order.class);
		List<Order> list;		
		list = criteria.add(Restrictions.eq("userId", userId)).list();	
		Set<String> setCat=new HashSet<>();
		for(int i=0;i<list.size();i++)
		{
			String pId=list.get(i).getProductId();			
			Product p= (Product)s.load(Product.class,pId);
			setCat.add(p.getCategory());
		}
		tx.commit();
		s.close();
		System.out.println("Items Fetched");
		return setCat;
	}
	public boolean cancelOrder(int userId,int orderId){
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Order order = (Order)s.load(Order.class,orderId);
		if(order.getUserId()==userId)
		{
			order.setOrderStatus("cancelled");
			s.update(order);
			System.out.println("Order cancelled");
			return true;
		}
		tx.commit();
		s.close();
		return false;		
	}
}
