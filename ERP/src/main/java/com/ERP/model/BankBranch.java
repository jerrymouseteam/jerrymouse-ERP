package com.ERP.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


public class BankBranch implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long bank_branch_id;
	private String branch_name;
	
	private String branch_ifsc;

	

	//private Bank bank;
	
	
   // private List<VendorBankProfile> vendor_bank_profile;

	public long getBank_branch_id() {
		return bank_branch_id;
	}

	public void setBank_branch_id(long bank_branch_id) {
		this.bank_branch_id = bank_branch_id;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getBranch_ifsc() {
		return branch_ifsc;
	}

	public void setBranch_ifsc(String branch_ifsc) {
		this.branch_ifsc = branch_ifsc;
	}

	

	/*public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}*/

	public BankBranch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankBranch(String branch_name, String branch_ifsc) {
		super();
		this.branch_name = branch_name;
		this.branch_ifsc = branch_ifsc;
		
	}

	@Override
	public String toString() {
		return "BankBranch [bank_branch_id=" + bank_branch_id + ", branch_name=" + branch_name + ", branch_ifsc="
				+ branch_ifsc + "]";
	}
	

	

	

	
	
	
	

}
