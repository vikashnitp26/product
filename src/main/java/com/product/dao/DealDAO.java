package com.product.dao;

import java.util.List;

import com.product.model.Deal;

public interface DealDAO {

	public Deal getDealByCategory(String cat);
	public List<Deal> getAllDeals();
	
}
