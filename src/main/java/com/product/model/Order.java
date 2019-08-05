package com.product.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="Orders")
@Component
public class Order implements Serializable {
	private static final long serialVersionUID = 2148379415619933775L;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	private int userId;
	private String sellerName;
	private int addressId;
	private String productId;
	private int quantity;
	private double totalPrice;
	private Date orderedDate;
	private String orderStatus;
	private String btnReviewProduct;
	private String btnReviewSeller;
	private String btnCancel;
	private String btnReturn;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getBtnReviewProduct() {
		return btnReviewProduct;
	}
	public void setBtnReviewProduct(String btnReviewProduct) {
		this.btnReviewProduct = btnReviewProduct;
	}
	public String getBtnReviewSeller() {
		return btnReviewSeller;
	}
	public void setBtnReviewSeller(String btnReviewSeller) {
		this.btnReviewSeller = btnReviewSeller;
	}
	public String getBtnCancel() {
		return btnCancel;
	}
	public void setBtnCancel(String btnCancel) {
		this.btnCancel = btnCancel;
	}
	public String getBtnReturn() {
		return btnReturn;
	}
	public void setBtnReturn(String btnReturn) {
		this.btnReturn = btnReturn;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", sellerName=" + sellerName + ", addressId="
				+ addressId + ", productId=" + productId + ", quantity=" + quantity + ", totalPrice=" + totalPrice
				+ ", orderedDate=" + orderedDate + ", orderStatus=" + orderStatus + ", btnReviewProduct="
				+ btnReviewProduct + ", btnReviewSeller=" + btnReviewSeller + ", btnCancel=" + btnCancel
				+ ", btnReturn=" + btnReturn + "]";
	}

}
