package com.craterzone.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.craterzone.model.User;

@Entity
@Table(name = "address")
public class AddressDao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column
	private String city;

	@Column
	private String state;

	@Column
	private String country;

	public AddressDao(String city, String state, String country) {
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public AddressDao() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "AddressDao [id=" + id + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}

}
