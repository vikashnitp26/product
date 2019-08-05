package com.product.dao.impl;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.product.dao.DealDAO;
import com.product.model.CartItem;
import com.product.model.Deal;
import com.product.model.Product;
public class DealDAOImpl implements DealDAO{

	@Autowired
	private SessionFactory sessionFactory;
	public List<Deal> list = new ArrayList<Deal>();

	
	public DealDAOImpl() {
		
	}

	public DealDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Deal getDealByCategory(String cat) {
		// TODO Auto-generated method stub
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		
		Criteria criteria = s.createCriteria(Deal.class);
		Deal deal= (Deal) criteria.add(Restrictions.eq("category", cat)).uniqueResult();
		tx.commit();
		s.close();
		System.out.println("Deal fetched by Category");	
		if(deal!=null) {return deal;}
		return null;
	}

	public List<Deal> getAllDeals() {
		// TODO Auto-generated method stub
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Criteria criteria = s.createCriteria(Deal.class);
		List<Deal> list;
		list = criteria.list();
		tx.commit();
		s.close();
		System.out.println("Products Fetched");
		return list;
	}

}
