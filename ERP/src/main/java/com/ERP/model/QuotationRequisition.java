package com.ERP.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class QuotationRequisition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long quotationRequisitionId;

	private boolean checked;

	private long requisitionId;

	private String requisitionStatus;

	private String requisitionDateOfGeneration;

	private String requisitionExpectedDelivery;

	private String requisitionRequestedBY;

	private String projectName;
	
	private long projectId;

	private String requisitionJustification;

	private Date createdDate;

	private Date updatedDate;

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public long getQuotationRequisitionId() {
		return quotationRequisitionId;
	}

	public void setQuotationRequisitionId(long quotationRequisitionId) {
		this.quotationRequisitionId = quotationRequisitionId;
	}

	

	public long getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(long requisitionId) {
		this.requisitionId = requisitionId;
	}

	public QuotationRequisition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRequisitionStatus() {
		return requisitionStatus;
	}

	public void setRequisitionStatus(String requisitionStatus) {
		this.requisitionStatus = requisitionStatus;
	}

	public String getRequisitionDateOfGeneration() {
		return requisitionDateOfGeneration;
	}

	public void setRequisitionDateOfGeneration(String requisitionDateOfGeneration) {
		this.requisitionDateOfGeneration = requisitionDateOfGeneration;
	}

	public String getRequisitionExpectedDelivery() {
		return requisitionExpectedDelivery;
	}

	public void setRequisitionExpectedDelivery(String requisitionExpectedDelivery) {
		this.requisitionExpectedDelivery = requisitionExpectedDelivery;
	}

	public String getRequisitionRequestedBY() {
		return requisitionRequestedBY;
	}

	public void setRequisitionRequestedBY(String requisitionRequestedBY) {
		this.requisitionRequestedBY = requisitionRequestedBY;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getRequisitionJustification() {
		return requisitionJustification;
	}

	public void setRequisitionJustification(String requisitionJustification) {
		this.requisitionJustification = requisitionJustification;
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
		return "QuotationRequisition [quotationRequisitionId=" + quotationRequisitionId + ", checked=" + checked
				+ ", requisitionId=" + requisitionId + ", requisitionStatus=" + requisitionStatus
				+ ", requisitionDateOfGeneration=" + requisitionDateOfGeneration + ", requisitionExpectedDelivery="
				+ requisitionExpectedDelivery + ", requisitionRequestedBY=" + requisitionRequestedBY + ", projectName="
				+ projectName + ", projectId=" + projectId + ", requisitionJustification=" + requisitionJustification
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

	
	

}
