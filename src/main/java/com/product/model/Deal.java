package com.product.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEAL")
public class Deal {

	@Id	
	@GeneratedValue
    @Column(name = "DEAL_ID", unique = true, nullable = false)
    private int dealId;
	
    @Column(name = "DISCOUNT")
	private int discount;
	@Column(name = "NAME")
	private String name;
    @Column(name = "Description")
	private String desc;
    @Column(name = "SHORTDESCRIPTION")
	private String sDesc;
    @Column(name = "CATEGORY")
	private String category;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
    public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getsDesc() {
		return sDesc;
	}
	public void setsDesc(String sDesc) {
		this.sDesc = sDesc;
	}
	public int getDealId() {
		return dealId;
	}
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
}
