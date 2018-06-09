package com.ERP.model;

import java.io.Serializable;

public class QuotationVendor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long quotationVendorId;

	private boolean quotationVendorChecked;

	private long vendorId;

	private String vendorName;

	public long getQuotationVendorId() {
		return quotationVendorId;
	}

	public void setQuotationVendorId(long quotationVendorId) {
		this.quotationVendorId = quotationVendorId;
	}

	public boolean isQuotationVendorChecked() {
		return quotationVendorChecked;
	}

	public void setQuotationVendorChecked(boolean quotationVendorChecked) {
		this.quotationVendorChecked = quotationVendorChecked;
	}

	public long getVendorId() {
		return vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	@Override
	public String toString() {
		return "QuotationVendor [quotationVendorId=" + quotationVendorId + ", quotationVendorChecked="
				+ quotationVendorChecked + ", vendorId=" + vendorId + ", vendorName=" + vendorName + "]";
	}

	public QuotationVendor() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	

}
