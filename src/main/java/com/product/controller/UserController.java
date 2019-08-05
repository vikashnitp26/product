package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.dao.UserDAO;
import com.product.model.User;



@RestController
public class UserController {
	@Autowired
	private UserDAO userDao;

	@PostMapping(path="/login", produces = "application/json")
	public String login(@RequestParam("userId") String uname,@RequestParam("password") String pwd) 
	{
		User user=userDao.get(uname);
		if(user.getPassword().equals(pwd))
			return "user:"+user.getFirstName()+" "+user.getLastName();
		return "wrong username or password";
	}
	
}
