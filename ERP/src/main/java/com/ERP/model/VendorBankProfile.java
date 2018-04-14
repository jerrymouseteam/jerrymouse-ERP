package com.ERP.model;

import java.io.Serializable;


public class VendorBankProfile implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long vendor_bank_profile_id;
	
	
	private Vendor vendor;
	
	
	
	
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
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
