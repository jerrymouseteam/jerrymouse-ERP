package com.ERPoAuth.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vendor_type_id")
	private VendorType vendor_type;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	private String contact_person_name;
	private String contact_person_email;
	private String contact_person_mobile;
	private String contact_person_alternate_phone_no;

	private String bank_account_number;

	private String bank_branch_ifsc;

	private String serviceRendered_GoodsSupplied;
	@Transient
	private long vendorTypeId;

	private String bank_name;

	private String bank_branch_name;

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

	
	public String getServiceRendered_GoodsSupplied() {
		return serviceRendered_GoodsSupplied;
	}

	public void setServiceRendered_GoodsSupplied(String serviceRendered_GoodsSupplied) {
		this.serviceRendered_GoodsSupplied = serviceRendered_GoodsSupplied;
	}

	public long getVendorTypeId() {
		return vendorTypeId;
	}

	public void setVendorTypeId(long vendorTypeId) {
		this.vendorTypeId = vendorTypeId;
	}

	public String getBank_account_number() {
		return bank_account_number;
	}

	public void setBank_account_number(String bank_account_number) {
		this.bank_account_number = bank_account_number;
	}

	public String getBank_branch_ifsc() {
		return bank_branch_ifsc;
	}

	public void setBank_branch_ifsc(String bank_branch_ifsc) {
		this.bank_branch_ifsc = bank_branch_ifsc;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBank_branch_name() {
		return bank_branch_name;
	}

	public void setBank_branch_name(String bank_branch_name) {
		this.bank_branch_name = bank_branch_name;
	}
	
	

	

	@Override
	public String toString() {
		return "Vendor [vendor_id=" + vendor_id + ", vendor_name=" + vendor_name + ", vendor_nickName="
				+ vendor_nickName + ", vendor_gst_number=" + vendor_gst_number + ", vendor_type=" + vendor_type
				+ ", address=" + address + ", contact_person_name=" + contact_person_name + ", contact_person_email="
				+ contact_person_email + ", contact_person_mobile=" + contact_person_mobile
				+ ", contact_person_alternate_phone_no=" + contact_person_alternate_phone_no + ", bank_account_number="
				+ bank_account_number + ", bank_branch_ifsc=" + bank_branch_ifsc + ", serviceRendered_GoodsSupplied="
				+ serviceRendered_GoodsSupplied + ", vendorTypeId=" + vendorTypeId + ", bank_name=" + bank_name
				+ ", bank_branch_name=" + bank_branch_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((bank_account_number == null) ? 0 : bank_account_number.hashCode());
		result = prime * result + ((bank_branch_ifsc == null) ? 0 : bank_branch_ifsc.hashCode());
		result = prime * result + ((bank_branch_name == null) ? 0 : bank_branch_name.hashCode());
		result = prime * result + ((bank_name == null) ? 0 : bank_name.hashCode());
		result = prime * result
				+ ((contact_person_alternate_phone_no == null) ? 0 : contact_person_alternate_phone_no.hashCode());
		result = prime * result + ((contact_person_email == null) ? 0 : contact_person_email.hashCode());
		result = prime * result + ((contact_person_mobile == null) ? 0 : contact_person_mobile.hashCode());
		result = prime * result + ((contact_person_name == null) ? 0 : contact_person_name.hashCode());
		result = prime * result
				+ ((serviceRendered_GoodsSupplied == null) ? 0 : serviceRendered_GoodsSupplied.hashCode());
		result = prime * result + (int) (vendorTypeId ^ (vendorTypeId >>> 32));
		result = prime * result + ((vendor_gst_number == null) ? 0 : vendor_gst_number.hashCode());
		result = prime * result + (int) (vendor_id ^ (vendor_id >>> 32));
		result = prime * result + ((vendor_name == null) ? 0 : vendor_name.hashCode());
		result = prime * result + ((vendor_nickName == null) ? 0 : vendor_nickName.hashCode());
		result = prime * result + ((vendor_type == null) ? 0 : vendor_type.hashCode());
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
		Vendor other = (Vendor) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (bank_account_number == null) {
			if (other.bank_account_number != null)
				return false;
		} else if (!bank_account_number.equals(other.bank_account_number))
			return false;
		if (bank_branch_ifsc == null) {
			if (other.bank_branch_ifsc != null)
				return false;
		} else if (!bank_branch_ifsc.equals(other.bank_branch_ifsc))
			return false;
		if (bank_branch_name == null) {
			if (other.bank_branch_name != null)
				return false;
		} else if (!bank_branch_name.equals(other.bank_branch_name))
			return false;
		if (bank_name == null) {
			if (other.bank_name != null)
				return false;
		} else if (!bank_name.equals(other.bank_name))
			return false;
		if (contact_person_alternate_phone_no == null) {
			if (other.contact_person_alternate_phone_no != null)
				return false;
		} else if (!contact_person_alternate_phone_no.equals(other.contact_person_alternate_phone_no))
			return false;
		if (contact_person_email == null) {
			if (other.contact_person_email != null)
				return false;
		} else if (!contact_person_email.equals(other.contact_person_email))
			return false;
		if (contact_person_mobile == null) {
			if (other.contact_person_mobile != null)
				return false;
		} else if (!contact_person_mobile.equals(other.contact_person_mobile))
			return false;
		if (contact_person_name == null) {
			if (other.contact_person_name != null)
				return false;
		} else if (!contact_person_name.equals(other.contact_person_name))
			return false;
		if (serviceRendered_GoodsSupplied == null) {
			if (other.serviceRendered_GoodsSupplied != null)
				return false;
		} else if (!serviceRendered_GoodsSupplied.equals(other.serviceRendered_GoodsSupplied))
			return false;
		if (vendorTypeId != other.vendorTypeId)
			return false;
		if (vendor_gst_number == null) {
			if (other.vendor_gst_number != null)
				return false;
		} else if (!vendor_gst_number.equals(other.vendor_gst_number))
			return false;
		if (vendor_id != other.vendor_id)
			return false;
		if (vendor_name == null) {
			if (other.vendor_name != null)
				return false;
		} else if (!vendor_name.equals(other.vendor_name))
			return false;
		if (vendor_nickName == null) {
			if (other.vendor_nickName != null)
				return false;
		} else if (!vendor_nickName.equals(other.vendor_nickName))
			return false;
		if (vendor_type == null) {
			if (other.vendor_type != null)
				return false;
		} else if (!vendor_type.equals(other.vendor_type))
			return false;
		return true;
	}
	
	
	

	

}
