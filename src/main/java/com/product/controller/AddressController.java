package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.dao.AddressDAO;
import com.product.dao.OrderDAO;
import com.product.model.Address;
import com.product.model.CartItem;

@RestController
public class AddressController {

	@Autowired
	private AddressDAO aDao;	
	@PostMapping(path="{userid}/address/add", produces = "application/json")
	public String getOrdersByUserId(@PathVariable("userid") int userId,@RequestParam("address") String address
			,@RequestParam("city") String city,@RequestParam("state") String state,
			@RequestParam("pinCode") String pinCode,@RequestParam("phoneNumber") String phoneNumber) 
	{	
		Address a=new Address();
		a.setAddressLine1(address);
		a.setCity(city);
		a.setPhoneNumber(phoneNumber);
		a.setUserId(userId);
		a.setPinCode(pinCode);
		a.setState(state);
		aDao.addAddress(a);
		return "Successfully Added";
	}
	@GetMapping(path="/{userId}/address/{addressid}", produces = "application/json")
	public Address getAddressToModify(@PathVariable("userId") int userId,@PathVariable("addressid") int addressId) 
   {
		 Address address=aDao.getAddressByUserId(userId);
		 if(address.getAddressId()!=addressId)
			 address= null;
		 return address;
   }
	@GetMapping(path="/{userId}/address/", produces = "application/json")
	public Address getAddress(@PathVariable("userId") int userId) 
   {
		 Address address=aDao.getAddressByUserId(userId);		
		 return address;
   }
	@PostMapping(path="/{userId}/address/{address}/delete", produces = "application/json")
	public String removeAddress(@PathVariable("userId") int userId,@PathVariable("addressid") int addressId) 
   {
		 Address address=aDao.getAddressByUserId(userId);
		 if(address.getAddressId()==addressId)
		 {
			 aDao.deleteAddress(address);
			 return "deleted";
		 }
		 else
			 return "not found";
   }
	
}
