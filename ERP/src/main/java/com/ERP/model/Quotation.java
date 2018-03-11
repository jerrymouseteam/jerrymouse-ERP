package com.ERP.model;

import java.io.Serializable;
import java.util.List;

public class Quotation implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean requisitionCheck;
	private List<Requisition> requisitionParameterses ;
	private List<VendorQuotation> vendorParameterses ;
	private String lastDateOfRFQSubmission;
	private String deliveryDate;
	private String termConditions;
	public boolean isRequisitionCheck() {
		return requisitionCheck;
	}
	public void setRequisitionCheck(boolean requisitionCheck) {
		this.requisitionCheck = requisitionCheck;
	}
	public List<Requisition> getRequisitionParameterses() {
		return requisitionParameterses;
	}
	public void setRequisitionParameterses(List<Requisition> requisitionParameterses) {
		this.requisitionParameterses = requisitionParameterses;
	}
	public List<VendorQuotation> getVendorParameterses() {
		return vendorParameterses;
	}
	public void setVendorParameterses(List<VendorQuotation> vendorParameterses) {
		this.vendorParameterses = vendorParameterses;
	}
	public String getLastDateOfRFQSubmission() {
		return lastDateOfRFQSubmission;
	}
	public void setLastDateOfRFQSubmission(String lastDateOfRFQSubmission) {
		this.lastDateOfRFQSubmission = lastDateOfRFQSubmission;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getTermConditions() {
		return termConditions;
	}
	public void setTermConditions(String termConditions) {
		this.termConditions = termConditions;
	}
	
	
	public Quotation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Quotation [requisitionCheck=" + requisitionCheck + ", requisitionParameterses="
				+ requisitionParameterses + ", vendorParameterses=" + vendorParameterses + ", lastDateOfRFQSubmission="
				+ lastDateOfRFQSubmission + ", deliveryDate=" + deliveryDate + ", termConditions=" + termConditions
				+ "]";
	}
	
	
	

}
