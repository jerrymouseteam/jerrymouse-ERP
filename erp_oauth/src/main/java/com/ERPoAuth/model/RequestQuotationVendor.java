package com.ERPoAuth.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "requestQuotationVendors")
public class RequestQuotationVendor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long requestQuotationVendorId;

	@OneToOne
	private RequestQuotation requestQuotation;

	@OneToOne
	private Vendor vendor;

	private String commment;

	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	public long getRequestQuotationVendorId() {
		return requestQuotationVendorId;
	}

	public void setRequestQuotationVendorId(long requestQuotationVendorId) {
		this.requestQuotationVendorId = requestQuotationVendorId;
	}

	public RequestQuotation getRequestQuotation() {
		return requestQuotation;
	}

	public void setRequestQuotation(RequestQuotation requestQuotation) {
		this.requestQuotation = requestQuotation;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public String getCommment() {
		return commment;
	}

	public void setCommment(String commment) {
		this.commment = commment;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public RequestQuotationVendor() {
		super();
		// TODO Auto-generated constructor stub
	}

}
