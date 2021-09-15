package com.cpo.bank.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;
import com.cpo.bank.model.User;
import com.cpo.bank.service.UserService;

@RestController

public class UserController {

	
	@Autowired
	UserService userService;
	
	// retrieve all user data
	
	@GetMapping("/allUsers")
	private List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	
	// get user by id
	@GetMapping("/user/{userid}")
	private User getUser(@PathVariable("userid") int userid) {
		return userService.getUserById(userid);
	}
	//add User
	@PostMapping("/user")
	private User saveUser(@RequestBody User user) {
		userService.addUser(user);
		return user;
	}
	
	
	// delete user by id
	@DeleteMapping("/user/{userid}")
	private void deleteUser(@PathVariable("userid") int userid) {
		userService.delete(userid);
	}

	
	
	
	// update a user details
	@PutMapping("/user")
	private User update(@RequestBody User user) {
		userService.updateUser(user);
		return user;
	}
	
	
}
