package com.product.dao;

import java.util.List;

import com.product.model.Product;

public interface ProductDAO {
	public void addProduct(Product newProduct);
	public Product getProduct(String p_id);
	public List<Product> getProductLikeName(String pName);
	public Product getProductByName(String pName);
	public void removeProduct(String p_id);
	public List<Product> getProductByCategory(String cat);
	public List<Product> getAllProducts();
}
