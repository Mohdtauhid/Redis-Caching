package com.craterzone.model;
  
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
  
  public class Address implements Serializable{
  private int id;
  private String city;
  private String state;
  private String country;
  
  public Address() 
  {
		super();
  }
	@Autowired
  public Address(String city, String state, String country) { 
	  this.city = city;
      this.state = state; 
      this.country = country; }
  
  public String getCity() { 
	  return city; }
	@Autowired
  public void setCity(String city) {
	  this.city = city; }
  
  public String getState() { 
	  return state; }
	@Autowired
  public void setState(String state) { 
	  this.state = state; }
  
  public String getCountry() { 
	  return country; }
	@Autowired
  public void setCountry(String country) { 
	  this.country = country; }
  
@Override
public String toString() {
	return "Address [id=" + id + ", city=" + city + ", state=" + state + ", country=" + country + "]";
}

  
  
  }
  
