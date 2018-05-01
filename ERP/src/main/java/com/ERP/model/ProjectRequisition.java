package com.ERP.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProjectRequisition implements Serializable {

	private static final long serialVersionUID = 1L;

	private long requisitionId;
	// private String requisitionType;

	private String requisitionStatus;

	private List<RequisitionItem> requisitionItems;

	private String requisitionDateOfGeneration;

	private String requisitionExpectedDelivery;

	private String requisitionRequestedBY;

	private Project project;
	private long projectId;

	private String requisitionJustification;
	 
	private Date requisitionCreatedDate;
	 
	private Date requisitionUpdatedDate;

	public long getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(long requisitionId) {
		this.requisitionId = requisitionId;
	}

	public String getRequisitionStatus() {
		return requisitionStatus;
	}

	public void setRequisitionStatus(String requisitionStatus) {
		this.requisitionStatus = requisitionStatus;
	}

	public List<RequisitionItem> getRequisitionItems() {
		return requisitionItems;
	}

	public void setRequisitionItems(List<RequisitionItem> requisitionItems) {
		this.requisitionItems = requisitionItems;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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

	public Date getRequisitionCreatedDate() {
		return requisitionCreatedDate;
	}

	public void setRequisitionCreatedDate(Date requisitionCreatedDate) {
		this.requisitionCreatedDate = requisitionCreatedDate;
	}

	public Date getRequisitionUpdatedDate() {
		return requisitionUpdatedDate;
	}

	public void setRequisitionUpdatedDate(Date requisitionUpdatedDate) {
		this.requisitionUpdatedDate = requisitionUpdatedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + (int) (projectId ^ (projectId >>> 32));
		result = prime * result + ((requisitionCreatedDate == null) ? 0 : requisitionCreatedDate.hashCode());
		result = prime * result + ((requisitionDateOfGeneration == null) ? 0 : requisitionDateOfGeneration.hashCode());
		result = prime * result + ((requisitionExpectedDelivery == null) ? 0 : requisitionExpectedDelivery.hashCode());
		result = prime * result + (int) (requisitionId ^ (requisitionId >>> 32));
		result = prime * result + ((requisitionItems == null) ? 0 : requisitionItems.hashCode());
		result = prime * result + ((requisitionJustification == null) ? 0 : requisitionJustification.hashCode());
		result = prime * result + ((requisitionRequestedBY == null) ? 0 : requisitionRequestedBY.hashCode());
		result = prime * result + ((requisitionStatus == null) ? 0 : requisitionStatus.hashCode());
		// result = prime * result + ((requisitionType == null) ? 0 :
		// requisitionType.hashCode());
		result = prime * result + ((requisitionUpdatedDate == null) ? 0 : requisitionUpdatedDate.hashCode());
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
		ProjectRequisition other = (ProjectRequisition) obj;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (projectId != other.projectId)
			return false;
		if (requisitionCreatedDate == null) {
			if (other.requisitionCreatedDate != null)
				return false;
		} else if (!requisitionCreatedDate.equals(other.requisitionCreatedDate))
			return false;
		if (requisitionDateOfGeneration == null) {
			if (other.requisitionDateOfGeneration != null)
				return false;
		} else if (!requisitionDateOfGeneration.equals(other.requisitionDateOfGeneration))
			return false;
		if (requisitionExpectedDelivery == null) {
			if (other.requisitionExpectedDelivery != null)
				return false;
		} else if (!requisitionExpectedDelivery.equals(other.requisitionExpectedDelivery))
			return false;
		if (requisitionId != other.requisitionId)
			return false;
		if (requisitionItems == null) {
			if (other.requisitionItems != null)
				return false;
		} else if (!requisitionItems.equals(other.requisitionItems))
			return false;
		if (requisitionJustification == null) {
			if (other.requisitionJustification != null)
				return false;
		} else if (!requisitionJustification.equals(other.requisitionJustification))
			return false;
		if (requisitionRequestedBY == null) {
			if (other.requisitionRequestedBY != null)
				return false;
		} else if (!requisitionRequestedBY.equals(other.requisitionRequestedBY))
			return false;
		if (requisitionStatus == null) {
			if (other.requisitionStatus != null)
				return false;
		} else if (!requisitionStatus.equals(other.requisitionStatus))
			return false;
		// if (requisitionType == null) {
		// if (other.requisitionType != null)
		// return false;
		// } else if (!requisitionType.equals(other.requisitionType))
		// return false;
		if (requisitionUpdatedDate == null) {
			if (other.requisitionUpdatedDate != null)
				return false;
		} else if (!requisitionUpdatedDate.equals(other.requisitionUpdatedDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProjectRequistion [requisitionId=" + requisitionId + ", requisitionStatus=" + requisitionStatus
				+ ", requisitionItems=" + requisitionItems + ", requisitionDateOfGeneration="
				+ requisitionDateOfGeneration + ", requisitionExpectedDelivery=" + requisitionExpectedDelivery
				+ ", requisitionRequestedBY=" + requisitionRequestedBY + ", project=" + project + ", projectId="
				+ projectId + ", requisitionJustification=" + requisitionJustification + ", requisitionCreatedDate="
				+ requisitionCreatedDate + ", requisitionUpdatedDate=" + requisitionUpdatedDate + "]";
	}

}
