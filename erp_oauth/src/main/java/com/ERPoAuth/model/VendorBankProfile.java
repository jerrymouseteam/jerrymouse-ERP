package com.ERPoAuth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="vendor_bank_profiles")
public class VendorBankProfile implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long vendor_bank_profile_id;
	
	@ManyToOne
	
	@JoinColumn(name = "vendor_id", nullable = false)
	@JsonBackReference
	private Vendor vendor;
	
	
	
	@ManyToOne
	@JoinColumn(name = "bank_branch_id", nullable = false)
	@JsonBackReference
	private BankBranch bank_branch;
	
	private String bank_account_number;
	public long getVendor_bank_profile_id() {
		return vendor_bank_profile_id;
	}
	public void setVendor_bank_profile_id(long vendor_bank_profile_id) {
		this.vendor_bank_profile_id = vendor_bank_profile_id;
	}
	
	
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public BankBranch getBank_branch() {
		return bank_branch;
	}
	public void setBank_branch(BankBranch bank_branch) {
		this.bank_branch = bank_branch;
	}
	public String getBank_account_number() {
		return bank_account_number;
	}
	public void setBank_account_number(String bank_account_number) {
		this.bank_account_number = bank_account_number;
	}
	public VendorBankProfile() {
		super();
	}
	
	
	
	

}
