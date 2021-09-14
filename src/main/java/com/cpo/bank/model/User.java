package com.cpo.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private final String firstName;
	private final String lastName;
	private final String email;
	private final int userType;
	
	
	
	public User(int id, String firstName, String lastName, String email, int userType) {
		super();
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userType = userType;
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public int getUserType() {
		return userType;
	}
	
	
}
