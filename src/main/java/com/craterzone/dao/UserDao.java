package com.craterzone.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserDao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
    @Column
	private String name;
    @Column
	private String password;
    @Column
	private String email;
    
    @OneToOne(cascade = CascadeType.ALL) 
	private MobileNumberDao mobileNumber;
  
	@OneToOne(cascade = CascadeType.ALL)
	private AddressDao address;

	public UserDao(int id, String name, String password,String email,MobileNumberDao mobileNumber,AddressDao address) {
		
		this.id = id;
		this.name = name;
		this.password=password;
		this.email=email;
		this.mobileNumber=mobileNumber;
		this.address=address;
	}

	public UserDao() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MobileNumberDao getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(MobileNumberDao mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public AddressDao getAddress() {
		return address;
	}

	public void setAddress(AddressDao address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserDao [id=" + id + ", name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", address=" + address + "]";
	}

}


