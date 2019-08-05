package com.product.details;

import java.util.List;

public class CartDetails {
	public List<ProductDetails> cartDetails;	
	public double totalprice;
	public double totaldeliverycharge;
	public double grandtotal;
	public CartDetails(List<ProductDetails> productDetails, double totalprice, double totaldeliverycharge,
			double grandtotal) {
		super();
		this.cartDetails = productDetails;
		this.totalprice = totalprice;
		this.totaldeliverycharge = totaldeliverycharge;
		this.grandtotal = grandtotal;
	}
	@Override
	public String toString() {
		return "CartDetails [cartDetails=" + cartDetails + ", totalprice=" + totalprice + ", totaldeliverycharge="
				+ totaldeliverycharge + ", grandtotal=" + grandtotal + "]";
	}
	
}
