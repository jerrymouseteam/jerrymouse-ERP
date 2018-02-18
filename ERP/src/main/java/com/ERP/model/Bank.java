package com.ERP.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


public class Bank implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long bank_id;
	
	private String bank_name;

	public long getBank_id() {
		return bank_id;
	}

	public void setBank_id(long bank_id) {
		this.bank_id = bank_id;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	@Override
	public String toString() {
		return "Bank [bank_id=" + bank_id + ", bank_name=" + bank_name + "]";
	}

	public Bank() {
		super();
	}
	

	public Bank(String bank_name) {
		super();
		this.bank_name = bank_name;
	}

	public Bank(long bank_id, String bank_name) {
		super();
		this.bank_id = bank_id;
		this.bank_name = bank_name;
	}
	
	
  
	
	
	
	
	
	
	
	

}
