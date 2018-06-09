package com.ERPoAuth.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "requestQuotationVendorRates")
public class RequestQuotationVendorRate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long requestQuotationVendorRateId;
	@OneToOne
	private RequestQuotationVendor requestQuotationVendor;
	@OneToOne
	private RequisitionItem requisitionItem;

	private BigDecimal materialRate;

	private BigDecimal rate;
	
	private BigDecimal amount;

	private String comment;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	public long getRequestQuotationVendorRateId() {
		return requestQuotationVendorRateId;
	}

	public void setRequestQuotationVendorRateId(long requestQuotationVendorRateId) {
		this.requestQuotationVendorRateId = requestQuotationVendorRateId;
	}

	public RequisitionItem getRequisitionItem() {
		return requisitionItem;
	}

	public void setRequisitionItem(RequisitionItem requisitionItem) {
		this.requisitionItem = requisitionItem;
	}

	public BigDecimal getMaterialRate() {
		return materialRate;
	}

	public void setMaterialRate(BigDecimal materialRate) {
		this.materialRate = materialRate;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public RequestQuotationVendorRate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestQuotationVendor getRequestQuotationVendor() {
		return requestQuotationVendor;
	}

	public void setRequestQuotationVendor(RequestQuotationVendor requestQuotationVendor) {
		this.requestQuotationVendor = requestQuotationVendor;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	

}
