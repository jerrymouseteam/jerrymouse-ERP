package com.ERP.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class RequestQuotation implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<QuotationRequisition> quotationRequisitions;
	private List<QuotationVendor> quotationVendors;
	private List<Vendor> vendors = new ArrayList<Vendor>();
	private List<KeyValueMapper> vendors2 = new ArrayList<KeyValueMapper>();
	private long key;

	private long requestQuotationId;

	private Date requestQuotationDeliveryDate;

	private Date lastDateOfRFQSubmission;

	private String requestQuotationStatus;
	private String comments;

	private ProjectRequisition projectRequisition;

	private String deliveryDate;

	private String lastSubmissinRFQ;

	private String comment;

	public List<KeyValueMapper> getVendors2() {
		return vendors2;
	}

	public void setVendors2(List<KeyValueMapper> vendors2) {
		this.vendors2 = vendors2;
	}

	public List<QuotationRequisition> getQuotationRequisitions() {
		return quotationRequisitions;
	}

	public void setQuotationRequisitions(List<QuotationRequisition> quotationRequisitions) {
		this.quotationRequisitions = quotationRequisitions;
	}

	public List<QuotationVendor> getQuotationVendors() {
		return quotationVendors;
	}

	public void setQuotationVendors(List<QuotationVendor> quotationVendors) {
		this.quotationVendors = quotationVendors;
	}

	public long getKey() {
		return key;
	}

	public void setKey(long key) {
		this.key = key;
	}

	public List<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getLastSubmissinRFQ() {
		return lastSubmissinRFQ;
	}

	public void setLastSubmissinRFQ(String lastSubmissinRFQ) {
		this.lastSubmissinRFQ = lastSubmissinRFQ;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public RequestQuotation() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public long getRequestQuotationId() {
		return requestQuotationId;
	}

	public void setRequestQuotationId(long requestQuotationId) {
		this.requestQuotationId = requestQuotationId;
	}

	public Date getRequestQuotationDeliveryDate() {
		return requestQuotationDeliveryDate;
	}

	public void setRequestQuotationDeliveryDate(Date requestQuotationDeliveryDate) {
		this.requestQuotationDeliveryDate = requestQuotationDeliveryDate;
	}

	public Date getLastDateOfRFQSubmission() {
		return lastDateOfRFQSubmission;
	}

	public void setLastDateOfRFQSubmission(Date lastDateOfRFQSubmission) {
		this.lastDateOfRFQSubmission = lastDateOfRFQSubmission;
	}

	public String getRequestQuotationStatus() {
		return requestQuotationStatus;
	}

	public void setRequestQuotationStatus(String requestQuotationStatus) {
		this.requestQuotationStatus = requestQuotationStatus;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public ProjectRequisition getProjectRequisition() {
		return projectRequisition;
	}

	public void setProjectRequisition(ProjectRequisition projectRequisition) {
		this.projectRequisition = projectRequisition;
	}

	@Override
	public String toString() {
		return "RequestQuotation [quotationRequisitions=" + quotationRequisitions + ", quotationVendors="
				+ quotationVendors + ", vendors=" + vendors + ", vendors2=" + vendors2 + ", key=" + key
				+ ", deliveryDate=" + deliveryDate + ", lastSubmissinRFQ=" + lastSubmissinRFQ + ", comment=" + comment
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
		result = prime * result + ((lastSubmissinRFQ == null) ? 0 : lastSubmissinRFQ.hashCode());
		result = prime * result + ((quotationRequisitions == null) ? 0 : quotationRequisitions.hashCode());
		result = prime * result + ((vendors == null) ? 0 : vendors.hashCode());
		result = prime * result + ((vendors2 == null) ? 0 : vendors2.hashCode());
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
		RequestQuotation other = (RequestQuotation) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
			return false;
		if (lastSubmissinRFQ == null) {
			if (other.lastSubmissinRFQ != null)
				return false;
		} else if (!lastSubmissinRFQ.equals(other.lastSubmissinRFQ))
			return false;
		if (quotationRequisitions == null) {
			if (other.quotationRequisitions != null)
				return false;
		} else if (!quotationRequisitions.equals(other.quotationRequisitions))
			return false;
		if (vendors == null) {
			if (other.vendors != null)
				return false;
		} else if (!vendors.equals(other.vendors))
			return false;
		if (vendors2 == null) {
			if (other.vendors2 != null)
				return false;
		} else if (!vendors2.equals(other.vendors2))
			return false;
		return true;
	}

}
