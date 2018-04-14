package com.ERP.model;

import java.io.Serializable;


public class Address implements Serializable 
{
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addres_line1 == null) ? 0 : addres_line1.hashCode());
		result = prime * result + ((addres_line2 == null) ? 0 : addres_line2.hashCode());
		result = prime * result + ((addres_line3 == null) ? 0 : addres_line3.hashCode());
		result = prime * result + (int) (address_id ^ (address_id >>> 32));
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (addres_line1 == null) {
			if (other.addres_line1 != null)
				return false;
		} else if (!addres_line1.equals(other.addres_line1))
			return false;
		if (addres_line2 == null) {
			if (other.addres_line2 != null)
				return false;
		} else if (!addres_line2.equals(other.addres_line2))
			return false;
		if (addres_line3 == null) {
			if (other.addres_line3 != null)
				return false;
		} else if (!addres_line3.equals(other.addres_line3))
			return false;
		if (address_id != other.address_id)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", addres_line1=" + addres_line1 + ", addres_line2=" + addres_line2
				+ ", addres_line3=" + addres_line3 + ", city=" + city + ", zipcode=" + zipcode + ", state=" + state
				+ ", country=" + country + "]";
	}
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
