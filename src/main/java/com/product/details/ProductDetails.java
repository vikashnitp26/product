package com.product.details;

public class ProductDetails {

	public String displayName;
	public String productId;
	public int kartItemId;
	public String category;
	public String sellerName;
	public double price;
	public int deliveryCharge;
	public int quantity;
	public double total;
	public double cartOfferPrice;
	
	public ProductDetails(String displayName, String productId, int kartItemId, String category, String sellerName,
			double price, int deliveryCharge, int quantity, double total, double cartOfferPrice) {
		super();
		this.displayName = displayName;
		this.productId = productId;
		this.kartItemId = kartItemId;
		this.category = category;
		this.sellerName = sellerName;
		this.price = price;
		this.deliveryCharge = deliveryCharge;
		this.quantity = quantity;
		this.total = total;
		this.cartOfferPrice = cartOfferPrice;
	}

	@Override
	public String toString() {
		return "ProductDetails [displayName=" + displayName + ", productId=" + productId + ", kartItemId=" + kartItemId
				+ ", category=" + category + ", sellerName=" + sellerName + ", price=" + price + ", deliveryCharge="
				+ deliveryCharge + ", quantity=" + quantity + ", total=" + total + ", cartOfferPrice=" + cartOfferPrice
				+ "]";
	}
	
}
