package com.ERPoAuth.model;

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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "bank_branches")

public class BankBranch implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bank_branch_id;
	private String branch_name;
	@Column(unique = true)
	private String branch_ifsc;

	@ManyToOne
	@JoinColumn(name = "bank_id", nullable = false)
	@JsonBackReference
	private Bank bank;

	
	@OneToMany(mappedBy = "bank_branch", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<VendorBankProfile> vendor_bank_profile;

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

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public BankBranch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankBranch(String branch_name, String branch_ifsc, Bank bank) {
		super();
		this.branch_name = branch_name;
		this.branch_ifsc = branch_ifsc;
		this.bank = bank;
	}

	public List<VendorBankProfile> getVendor_bank_profile() {
		return vendor_bank_profile;
	}

	public void setVendor_bank_profile(List<VendorBankProfile> vendor_bank_profile) {
		this.vendor_bank_profile = vendor_bank_profile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
		result = prime * result + (int) (bank_branch_id ^ (bank_branch_id >>> 32));
		result = prime * result + ((branch_ifsc == null) ? 0 : branch_ifsc.hashCode());
		result = prime * result + ((branch_name == null) ? 0 : branch_name.hashCode());
		result = prime * result + ((vendor_bank_profile == null) ? 0 : vendor_bank_profile.hashCode());
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
		BankBranch other = (BankBranch) obj;
		if (bank == null) {
			if (other.bank != null)
				return false;
		} else if (!bank.equals(other.bank))
			return false;
		if (bank_branch_id != other.bank_branch_id)
			return false;
		if (branch_ifsc == null) {
			if (other.branch_ifsc != null)
				return false;
		} else if (!branch_ifsc.equals(other.branch_ifsc))
			return false;
		if (branch_name == null) {
			if (other.branch_name != null)
				return false;
		} else if (!branch_name.equals(other.branch_name))
			return false;
		if (vendor_bank_profile == null) {
			if (other.vendor_bank_profile != null)
				return false;
		} else if (!vendor_bank_profile.equals(other.vendor_bank_profile))
			return false;
		return true;
	}

}
