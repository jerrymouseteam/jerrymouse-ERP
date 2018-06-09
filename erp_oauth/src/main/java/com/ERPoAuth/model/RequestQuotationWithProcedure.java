package com.ERPoAuth.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class RequestQuotationWithProcedure implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long requestQuotationId;
	private String requestQuotationComments;
	private String requestQuotationDeliveryDate;
	private String lastDateOfRFQSubmission;
	private String requestQuotationStatus;
	private long requisitionId;
	
	private String vendorStatus;
	private String vendorNames;
	private long vendorNamesTotalCount;
	public Long getRequestQuotationId() {
		return requestQuotationId;
	}
	public void setRequestQuotationId(Long requestQuotationId) {
		this.requestQuotationId = requestQuotationId;
	}
	public String getRequestQuotationComments() {
		return requestQuotationComments;
	}
	public void setRequestQuotationComments(String requestQuotationComments) {
		this.requestQuotationComments = requestQuotationComments;
	}
	public String getRequestQuotationDeliveryDate() {
		return requestQuotationDeliveryDate;
	}
	public void setRequestQuotationDeliveryDate(String requestQuotationDeliveryDate) {
		this.requestQuotationDeliveryDate = requestQuotationDeliveryDate;
	}
	public String getLastDateOfRFQSubmission() {
		return lastDateOfRFQSubmission;
	}
	public void setLastDateOfRFQSubmission(String lastDateOfRFQSubmission) {
		this.lastDateOfRFQSubmission = lastDateOfRFQSubmission;
	}
	public String getRequestQuotationStatus() {
		return requestQuotationStatus;
	}
	public void setRequestQuotationStatus(String requestQuotationStatus) {
		this.requestQuotationStatus = requestQuotationStatus;
	}
	public long getRequisitionId() {
		return requisitionId;
	}
	public void setRequisitionId(long requisitionId) {
		this.requisitionId = requisitionId;
	}
	public String getVendorStatus() {
		return vendorStatus;
	}
	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}
	public String getVendorNames() {
		return vendorNames;
	}
	public void setVendorNames(String vendorNames) {
		this.vendorNames = vendorNames;
	}
	public long getVendorNamesTotalCount() {
		return vendorNamesTotalCount;
	}
	public void setVendorNamesTotalCount(long vendorNamesTotalCount) {
		this.vendorNamesTotalCount = vendorNamesTotalCount;
	}
	
	
	
	
	

	
	
	

}
