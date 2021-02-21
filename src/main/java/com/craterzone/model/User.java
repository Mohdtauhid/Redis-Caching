package com.craterzone.model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

public class User implements Serializable{

	private int id;
	private String name;
	private String password;
	private String email;
	@Autowired
	private MobileNumber mobileNumber;
	@Autowired
	private Address address;
	@Autowired
	public User( String name,String password, String email, MobileNumber mobileNumber, Address address) 
	{
		this.name = name;
		this.password=password;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}
	@Autowired
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	@Autowired
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	@Autowired
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	@Autowired
	public void setEmail(String email) {
		this.email = email;
	}

	public MobileNumber getMobileNumber() {
		return mobileNumber;
	}
	@Autowired
	public void setMobileNumber(MobileNumber mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Address getAddress() {
		return address;
	}
	@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", address=" + address + "]";
	}

}


