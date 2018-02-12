package com.ERP.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Address implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private long address_id;
	private String addres_line1;
	private String addres_line2;
	private String addres_line3;
	private String city;
	private String zipcode;
	private String state;
	private String country;
	public long getAddress_id() {
		return address_id;
	}
	public void setAddress_id(long address_id) {
		this.address_id = address_id;
	}
	public String getAddres_line1() {
		return addres_line1;
	}
	public void setAddres_line1(String addres_line1) {
		this.addres_line1 = addres_line1;
	}
	public String getAddres_line2() {
		return addres_line2;
	}
	public void setAddres_line2(String addres_line2) {
		this.addres_line2 = addres_line2;
	}
	public String getAddres_line3() {
		return addres_line3;
	}
	public void setAddres_line3(String addres_line3) {
		this.addres_line3 = addres_line3;
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
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
	

}
