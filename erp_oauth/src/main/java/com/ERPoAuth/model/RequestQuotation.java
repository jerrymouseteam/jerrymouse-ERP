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
@Table(name = "requestQuotations")
public class RequestQuotation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long requestQuotationId;

	@Temporal(TemporalType.DATE)
	private Date requestQuotationDeliveryDate;
	@Temporal(TemporalType.DATE)
	private Date lastDateOfRFQSubmission;

	private String requestQuotationStatus;
	private String comments;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@OneToOne
	private ProjectRequisition projectRequisition;

	
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

	

	
	@Override
	public String toString() {
		return "RequestQuotation [requestQuotationId=" + requestQuotationId + ", requestQuotationDeliveryDate="
				+ requestQuotationDeliveryDate + ", lastDateOfRFQSubmission=" + lastDateOfRFQSubmission
				+ ", requestQuotationStatus=" + requestQuotationStatus + ", comments=" + comments + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", projectRequisition=" + projectRequisition + "]";
	}

	public RequestQuotation() {
		super();
		// TODO Auto-generated constructor stub
	}

}
