package com.cpo.bank.service;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;
import com.cpo.bank.model.User;
import com.cpo.bank.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers(){
		List<User> user = new ArrayList<User>();
		userRepository.findAll().forEach(user1 -> user.add(user1));
		return user;
	}
	
	//get specific record by using findById()
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}
	
	//save specific record by using save()
	public void saveOrUpdate(User user) {
		userRepository.save(user);
	}
	
	//delete specific record by using deleteById()
	public void delete(int id) {
		userRepository.deleteById(id);
	}
	
	//update a record
	public void update(User user, int userid) {
		userRepository.save(user);
	}

}
