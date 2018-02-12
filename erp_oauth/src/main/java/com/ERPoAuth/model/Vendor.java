package com.ERPoAuth.model;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "vendors")
public class Vendor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long vendor_id;
	private String vendor_name;
	private String vendor_nickName;
	private String vendor_gst_number;
	@OneToOne
	@JoinColumn(name = "vendor_type_id")
	@JsonBackReference
	private VendorType vendor_type;
	@OneToOne
	@JsonBackReference
	@JoinColumn(name = "address_id")
	private Address address;
	private String contact_person_name;
	private String contact_person_email;
	private String contact_person_mobile;
	private String contact_person_alternate_phone_no;
	
	@OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
	@JsonManagedReference
    private List<VendorBankProfile> vendor_bank_profiles;

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

	public void setVendor_nickName(String vendor_nickName) {
		this.vendor_nickName = vendor_nickName;
	}

	

	public String getVendor_gst_number() {
		return vendor_gst_number;
	}

	public void setVendor_gst_number(String vendor_gst_number) {
		this.vendor_gst_number = vendor_gst_number;
	}

	public VendorType getVendor_type() {
		return vendor_type;
	}

	public void setVendor_type(VendorType vendor_type) {
		this.vendor_type = vendor_type;
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

	@Override
	public String toString() {
		return "Vendor [vendor_id=" + vendor_id + ", vendor_name=" + vendor_name + ", vendor_nickName="
				+ vendor_nickName + ", vendor_gst_number=" + vendor_gst_number + ", vendor_type=" + vendor_type
				+ ", address=" + address + ", contact_person_name=" + contact_person_name + ", contact_person_email="
				+ contact_person_email + ", contact_person_mobile=" + contact_person_mobile
				+ ", contact_person_alternate_phone_no=" + contact_person_alternate_phone_no + "]";
	}

	public List<VendorBankProfile> getVendor_bank_profiles() {
		return vendor_bank_profiles;
	}

	public void setVendor_bank_profiles(List<VendorBankProfile> vendor_bank_profiles) {
		this.vendor_bank_profiles = vendor_bank_profiles;
	}
	
	

	
	

}
