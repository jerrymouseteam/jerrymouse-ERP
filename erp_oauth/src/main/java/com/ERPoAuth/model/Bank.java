package com.ERPoAuth.model;

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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "banks")
public class Bank implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bank_id;
	@Column(unique = true)
	private String bank_name;

	@OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<BankBranch> bank_branches;

	public Bank() {
		super();
	}

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

	public Bank(String bank_name) {
		super();
		this.bank_name = bank_name;
	}

	public List<BankBranch> getBank_branches() {
		return bank_branches;
	}

	public void setBank_branches(List<BankBranch> bank_branches) {
		this.bank_branches = bank_branches;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bank_branches == null) ? 0 : bank_branches.hashCode());
		result = prime * result + (int) (bank_id ^ (bank_id >>> 32));
		result = prime * result + ((bank_name == null) ? 0 : bank_name.hashCode());
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
		Bank other = (Bank) obj;
		if (bank_branches == null) {
			if (other.bank_branches != null)
				return false;
		} else if (!bank_branches.equals(other.bank_branches))
			return false;
		if (bank_id != other.bank_id)
			return false;
		if (bank_name == null) {
			if (other.bank_name != null)
				return false;
		} else if (!bank_name.equals(other.bank_name))
			return false;
		return true;
	}

}
