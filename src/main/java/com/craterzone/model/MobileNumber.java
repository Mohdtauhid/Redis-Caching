package com.craterzone.model;
    
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
  
  public class MobileNumber implements Serializable {
  private int id;
  private String cc;                                                   // Country Code +91
  private String number;
  
  public MobileNumber() {
	super();
}
	@Autowired
  public MobileNumber( String cc, String number)
  {
	this.cc = cc;
	this.number = number;
  }


	public String getCc() { 
	  return cc; }
@Autowired
  public void setCc(String cc) { 
	  this.cc = cc; }
  
  public String getNumber() { 
	  return number; 
	  }
	@Autowired
  public void setNumber(String number) { 
	  this.number = number; 
	  }

@Override
public String toString() {
	return "MobileNumber [id=" + id + ", cc=" + cc + ", number=" + number + "]";
}


  }
 