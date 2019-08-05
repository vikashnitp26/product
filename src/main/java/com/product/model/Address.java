package com.product.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;
@Entity
@Table(name="Address")
@Component
public class Address implements Serializable {
	private static final long serialVersionUID = 2148379415619933775L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Min(1)
	private int addressId;
	private int userId;
	@NotNull
    @Size(min=2, max=30)
	private String addressLine1;
	private String addressLine2;
	@Pattern(regexp="[a-zA-Z]+",message="City name should not contain digits or special character")
	private String city;
	@Pattern(regexp="[a-zA-Z ]+",message="State name should not contain digits or special character")
	private String state;
	@Pattern(regexp="\\d{6}",message="Pin no. shoud have 6 digits")
	private String pinCode;
	@Pattern(regexp="[6-9]\\d{9}",message="Please enter valid phone number")
	private String phoneNumber;
		
	public Address() {
		super();
	}
	

	public Address(int addressId, int userId, String addressLine1, String addressLine2, String city, String state,
			String pinCode, String phoneNumber) {
		super();
		this.addressId = addressId;
		this.userId = userId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.phoneNumber = phoneNumber;
	}


	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}


	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	public String getAddressLine2() {
		return addressLine2;
	}


	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", userId=" + userId + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", pinCode=" + pinCode
				+ ", phoneNumber=" + phoneNumber + "]";
	}

	
}
