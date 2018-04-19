package com.ERPoAuth.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(name="requisitions")
public class ProjectRequistion implements Serializable {
	
//	
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private long reuisitionId;
//	
//	private String requisitionStatus;
//	
//	@OneToMany(cascade=CascadeType.ALL,mappedBy="requisition")
//	private List<RequisitionItem> requistionItems;
//	
//	@Temporal(TemporalType.DATE)
//	private Date requisitionDateOfGeneration;
//	
//	@Temporal(TemporalType.DATE)
//	private Date requisitionExpectedDelivery;
//	
//
//	private String requisitionRequestedBY;
//
//	@OneToOne
//	@JoinColumn(name="project_id")
//	private Project project;
//	
//	private String requisitionJustification;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date requisitionCreatedDate;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date requisitionUpdatedDate;
//
//	public long getReuisitionId() {
//		return reuisitionId;
//	}
//
//	public void setReuisitionId(long reuisitionId) {
//		this.reuisitionId = reuisitionId;
//	}
//
//	public String getRequisitionStatus() {
//		return requisitionStatus;
//	}
//
//	public void setRequisitionStatus(String requisitionStatus) {
//		this.requisitionStatus = requisitionStatus;
//	}
//
//	public List<RequisitionItem> getRequistionItems() {
//		return requistionItems;
//	}
//
//	public void setRequistionItems(List<RequisitionItem> requistionItems) {
//		this.requistionItems = requistionItems;
//	}
//
//	public Date getRequisitionDateOfGeneration() {
//		return requisitionDateOfGeneration;
//	}
//
//	public void setRequisitionDateOfGeneration(Date requisitionDateOfGeneration) {
//		this.requisitionDateOfGeneration = requisitionDateOfGeneration;
//	}
//
//	public Date getRequisitionExpectedDelivery() {
//		return requisitionExpectedDelivery;
//	}
//
//	public void setRequisitionExpectedDelivery(Date requisitionExpectedDelivery) {
//		this.requisitionExpectedDelivery = requisitionExpectedDelivery;
//	}
//
//	public String getRequisitionRequestedBY() {
//		return requisitionRequestedBY;
//	}
//
//	public void setRequisitionRequestedBY(String requisitionRequestedBY) {
//		this.requisitionRequestedBY = requisitionRequestedBY;
//	}
//
//	public Project getProject() {
//		return project;
//	}
//
//	public void setProject(Project project) {
//		this.project = project;
//	}
//
//	public String getRequisitionJustification() {
//		return requisitionJustification;
//	}
//
//	public void setRequisitionJustification(String requisitionJustification) {
//		this.requisitionJustification = requisitionJustification;
//	}
//
//	public Date getRequisitionCreatedDate() {
//		return requisitionCreatedDate;
//	}
//
//	public void setRequisitionCreatedDate(Date requisitionCreatedDate) {
//		this.requisitionCreatedDate = requisitionCreatedDate;
//	}
//
//	public Date getRequisitionUpdatedDate() {
//		return requisitionUpdatedDate;
//	}
//
//	public void setRequisitionUpdatedDate(Date requisitionUpdatedDate) {
//		this.requisitionUpdatedDate = requisitionUpdatedDate;
//	}
//
//	public ProjectRequistion() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public String toString() {
//		return "Requisition [reuisitionId=" + reuisitionId + ", requisitionStatus=" + requisitionStatus
//				+ ", requistionItems=" + requistionItems + ", requisitionDateOfGeneration="
//				+ requisitionDateOfGeneration + ", requisitionExpectedDelivery=" + requisitionExpectedDelivery
//				+ ", requisitionRequestedBY=" + requisitionRequestedBY + ", requisitionJustification="
//				+ requisitionJustification + ", requisitionCreatedDate=" + requisitionCreatedDate
//				+ ", requisitionUpdatedDate=" + requisitionUpdatedDate + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((project == null) ? 0 : project.hashCode());
//		result = prime * result + ((requisitionCreatedDate == null) ? 0 : requisitionCreatedDate.hashCode());
//		result = prime * result + ((requisitionDateOfGeneration == null) ? 0 : requisitionDateOfGeneration.hashCode());
//		result = prime * result + ((requisitionExpectedDelivery == null) ? 0 : requisitionExpectedDelivery.hashCode());
//		result = prime * result + ((requisitionJustification == null) ? 0 : requisitionJustification.hashCode());
//		result = prime * result + ((requisitionRequestedBY == null) ? 0 : requisitionRequestedBY.hashCode());
//		result = prime * result + ((requisitionStatus == null) ? 0 : requisitionStatus.hashCode());
//		result = prime * result + ((requisitionUpdatedDate == null) ? 0 : requisitionUpdatedDate.hashCode());
//		result = prime * result + ((requistionItems == null) ? 0 : requistionItems.hashCode());
//		result = prime * result + (int) (reuisitionId ^ (reuisitionId >>> 32));
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ProjectRequistion other = (ProjectRequistion) obj;
//		if (project == null) {
//			if (other.project != null)
//				return false;
//		} else if (!project.equals(other.project))
//			return false;
//		if (requisitionCreatedDate == null) {
//			if (other.requisitionCreatedDate != null)
//				return false;
//		} else if (!requisitionCreatedDate.equals(other.requisitionCreatedDate))
//			return false;
//		if (requisitionDateOfGeneration == null) {
//			if (other.requisitionDateOfGeneration != null)
//				return false;
//		} else if (!requisitionDateOfGeneration.equals(other.requisitionDateOfGeneration))
//			return false;
//		if (requisitionExpectedDelivery == null) {
//			if (other.requisitionExpectedDelivery != null)
//				return false;
//		} else if (!requisitionExpectedDelivery.equals(other.requisitionExpectedDelivery))
//			return false;
//		if (requisitionJustification == null) {
//			if (other.requisitionJustification != null)
//				return false;
//		} else if (!requisitionJustification.equals(other.requisitionJustification))
//			return false;
//		if (requisitionRequestedBY == null) {
//			if (other.requisitionRequestedBY != null)
//				return false;
//		} else if (!requisitionRequestedBY.equals(other.requisitionRequestedBY))
//			return false;
//		if (requisitionStatus == null) {
//			if (other.requisitionStatus != null)
//				return false;
//		} else if (!requisitionStatus.equals(other.requisitionStatus))
//			return false;
//		if (requisitionUpdatedDate == null) {
//			if (other.requisitionUpdatedDate != null)
//				return false;
//		} else if (!requisitionUpdatedDate.equals(other.requisitionUpdatedDate))
//			return false;
//		if (requistionItems == null) {
//			if (other.requistionItems != null)
//				return false;
//		} else if (!requistionItems.equals(other.requistionItems))
//			return false;
//		if (reuisitionId != other.reuisitionId)
//			return false;
//		return true;
//	}
//
//	
//	
	
	
}
