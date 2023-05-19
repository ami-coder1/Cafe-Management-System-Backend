package com.example.demo.controller;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.ServiceImplementation;

@RestController
@RequestMapping("user")
public class UserController {

	private ServiceImplementation si;

	@Autowired
	public UserController(ServiceImplementation si) {
		
		this.si = si;
	}
	
	@GetMapping("list")
	//@CrossOrigin(origins = "http://localhost:4200")
	public List<User> display() {
		
		return si.displayAllUser();
	}
	
	/*@PostMapping("list")
	public void insert(@RequestBody User user) {
	
		si.insertUser(user);	
	}*/
	
	@PostMapping("register")
	@CrossOrigin(origins = "http://localhost:4200")
	public User insert(@RequestBody User user) throws Exception
	{
		String tempEmail = user.getUserEmail();
		//int tempId = user.getId();
		if(tempEmail != null && !"".equals(tempEmail)) {
			User userobj = si.fetchUserByEmailId(tempEmail);
			
		  if(userobj != null) {
				throw new Exception("user with " + tempEmail + " already exist!");
			}
		}
		
		User userObj = null;
	     userObj = si.insertUser(user);
		
	     return userObj;
	}
	
	@PostMapping("login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception{
		
		Encoder encoder = Base64.getEncoder();
		String tempEmail = user.getUserEmail();
		String tempPassword =user.getUserPassword();
		String encodepassword=encoder.encodeToString(tempPassword.getBytes());
		User userObj = null; 
		if(tempEmail != null && encodepassword != null) 
		{ userObj = si.fetchUserByEmailIdAndPassword(tempEmail, encodepassword); } 
		if(userObj == null) {
		  throw new Exception("Invalid Credentials"); }

		return userObj;
		
	}
	
	/*
	@PutMapping("list")
	public void update(@RequestBody User user)
	{
		si.updateUser(user);
	}*/
	
	@GetMapping("list1/{userid}")
	public User search(@PathVariable("userid") int uid) {
		
		return si.searchByUserId(uid);
	}
	
	@GetMapping("list2/{username}")
	public List<User> search(@PathVariable("username") String userName) {
		
		return si.searchByUserName(userName);
	}
	
	@DeleteMapping("list/{userid}")
	public void delete(@PathVariable("userid") int uid) {
		
		si.deleteUser(uid);
	}
}
