package com.product.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.product.dao.AddressDAO;
import com.product.model.Address;
import com.product.model.Deal;
import com.product.model.Address;
import com.product.model.Product;

public class AddressDAOImpl implements AddressDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public AddressDAOImpl() {
		
	}

	public AddressDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Address getAddressByUserId(int userId)
	{
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		
		Criteria criteria = s.createCriteria(Address.class);
		Address address= (Address) criteria.add(Restrictions.eq("userId", userId)).uniqueResult();
		tx.commit();
		s.close();
		System.out.println("Address fetched by id");	
		if(address!=null) {return address;}
		return null;
	}
	
	public void addAddress(Address address)
	{
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Address address1= getAddressByUserId(address.getUserId());
		if(address1!=null)
		s.delete(address1);
		s.saveOrUpdate(address);
		
		tx.commit();
		s.close();
		System.out.println("Address inserted");	
	}
	public void deleteAddress(Address address)
	{
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		s.delete(address);
		
		tx.commit();
		s.close();
		System.out.println("Address inserted");	
	}
//	public Address getAddress(int userId)
//	{
//		Session s=  sessionFactory.openSession();
//		Transaction tx = s.beginTransaction();
//		
//		Criteria criteria = s.createCriteria(Address.class);
//		Address address= (Address) criteria.add(Restrictions.eq("userId", userId)).uniqueResult();
//		tx.commit();
//		s.close();
//		System.out.println("Address fetched by id");	
//		if(address!=null) {return address;}
//		return null;
//	}
}
