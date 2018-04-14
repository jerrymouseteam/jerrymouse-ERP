package com.ERP.model;

import java.io.Serializable;
import java.util.List;



public class VendorQuotation implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean vendorCheck;
	private List<com.ERP.model.Vendor> vendors ;
	public boolean isVendorCheck() {
		return vendorCheck;
	}
	public void setVendorCheck(boolean vendorCheck) {
		this.vendorCheck = vendorCheck;
	}
	public List<com.ERP.model.Vendor> getVendors() {
		return vendors;
	}
	public void setVendors(List<com.ERP.model.Vendor> vendors) {
		this.vendors = vendors;
	}
	public VendorQuotation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "VendorQuotation [vendorCheck=" + vendorCheck + ", vendors=" + vendors + "]";
	}
	
	
	
	
	

}
