package com.ERP.model;

import java.io.Serializable;


public class VendorType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long vendorType_id;
	
	private String vendorType_name;

	public long getVendorType_id() {
		return vendorType_id;
	}

	public void setVendorType_id(long vendorType_id) {
		this.vendorType_id = vendorType_id;
	}

	public String getVendorType_name() {
		return vendorType_name;
	}

	public void setVendorType_name(String vendorType_name) {
		this.vendorType_name = vendorType_name;
	}

	public VendorType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VendorType(long vendorType_id, String vendorType_name) {
		super();
		this.vendorType_id = vendorType_id;
		this.vendorType_name = vendorType_name;
	}

	@Override
	public String toString() {
		return "VendorType [vendorType_id=" + vendorType_id + ", vendorType_name=" + vendorType_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (vendorType_id ^ (vendorType_id >>> 32));
		result = prime * result + ((vendorType_name == null) ? 0 : vendorType_name.hashCode());
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
		VendorType other = (VendorType) obj;
		if (vendorType_id != other.vendorType_id)
			return false;
		if (vendorType_name == null) {
			if (other.vendorType_name != null)
				return false;
		} else if (!vendorType_name.equals(other.vendorType_name))
			return false;
		return true;
	}

	
	
	

}
