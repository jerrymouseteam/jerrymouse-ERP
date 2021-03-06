package com.ERP.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class Vendor implements Serializable {

	private static final long serialVersionUID = 1L;

	private long vendor_id;
	private String vendor_name;
	private String vendor_nickName;
	private String vendor_gst_number;
	private String bankAccountNumber;
	private String branch_ifsc;
	private String serviceRendered_GoodsSupplied;
	private Address address;
	private String contact_person_name;
	private String contact_person_email;
	private String contact_person_mobile;
	private String contact_person_alternate_phone_no;
	private long vendorTypeId;
	private long bankId;
	private long branchId;

	public Vendor() {
		super();
	}

	public long getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(long vendor_id) {
		this.vendor_id = vendor_id;
	}

	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	public String getVendor_nickName() {
		return vendor_nickName;
	}

	public String getServiceRendered_GoodsSupplied() {
		return serviceRendered_GoodsSupplied;
	}

	public void setServiceRendered_GoodsSupplied(String serviceRendered_GoodsSupplied) {
		this.serviceRendered_GoodsSupplied = serviceRendered_GoodsSupplied;
	}

	public void setVendor_nickName(String vendor_nickName) {
		this.vendor_nickName = vendor_nickName;
	}

	public String getVendor_gst_number() {
		return vendor_gst_number;
	}

	public void setVendor_gst_number(String vendor_gst_number) {
		this.vendor_gst_number = vendor_gst_number;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getContact_person_name() {
		return contact_person_name;
	}

	public void setContact_person_name(String contact_person_name) {
		this.contact_person_name = contact_person_name;
	}

	public String getContact_person_email() {
		return contact_person_email;
	}

	public void setContact_person_email(String contact_person_email) {
		this.contact_person_email = contact_person_email;
	}

	public String getContact_person_mobile() {
		return contact_person_mobile;
	}

	public void setContact_person_mobile(String contact_person_mobile) {
		this.contact_person_mobile = contact_person_mobile;
	}

	public String getContact_person_alternate_phone_no() {
		return contact_person_alternate_phone_no;
	}

	public void setContact_person_alternate_phone_no(String contact_person_alternate_phone_no) {
		this.contact_person_alternate_phone_no = contact_person_alternate_phone_no;
	}

	public String getBranch_ifsc() {
		return branch_ifsc;
	}

	public void setBranch_ifsc(String branch_ifsc) {
		this.branch_ifsc = branch_ifsc;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public long getVendorTypeId() {
		return vendorTypeId;
	}

	public void setVendorTypeId(long vendorTypeId) {
		this.vendorTypeId = vendorTypeId;
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public long getBranchId() {
		return branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	@Override
	public String toString() {
		return "Vendor [vendor_id=" + vendor_id + ", vendor_name=" + vendor_name + ", vendor_nickName="
				+ vendor_nickName + ", vendor_gst_number=" + vendor_gst_number + ", bankAccountNumber="
				+ bankAccountNumber + ", branch_ifsc=" + branch_ifsc + ", serviceRendered_GoodsSupplied="
				+ serviceRendered_GoodsSupplied + ", address=" + address + ", contact_person_name="
				+ contact_person_name + ", contact_person_email=" + contact_person_email + ", contact_person_mobile="
				+ contact_person_mobile + ", contact_person_alternate_phone_no=" + contact_person_alternate_phone_no
				+ ", vendorTypeId=" + vendorTypeId + ", bankId=" + bankId + ", branchId=" + branchId + "]";
	}

}
