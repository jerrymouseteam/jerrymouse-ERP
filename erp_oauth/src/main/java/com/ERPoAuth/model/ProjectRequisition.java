package com.ERPoAuth.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="project_requisitions")
public class ProjectRequisition implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long requisitionId;
	
	private String requisitionStatus;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="projectRequisition",fetch=FetchType.EAGER)
	private List<RequisitionItem> requisitionItems;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat
    (shape = JsonFormat.Shape.OBJECT, pattern = "yyyy-MM-dd")
	private Date requisitionDateOfGeneration;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat
    (shape = JsonFormat.Shape.OBJECT, pattern = "yyyy-MM-dd")
	private Date requisitionExpectedDelivery;
	

	private String requisitionRequestedBY;

	@OneToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	private String requisitionJustification;

	@Temporal(TemporalType.TIMESTAMP)
	 @JsonFormat
     (shape = JsonFormat.Shape.OBJECT, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date requisitionCreatedDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	 @JsonFormat
     (shape = JsonFormat.Shape.OBJECT, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date requisitionUpdatedDate;
	

	@Transient
	private long projectId;

	


	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

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

	public Date getRequisitionDateOfGeneration() {
		return requisitionDateOfGeneration;
	}

	public void setRequisitionDateOfGeneration(Date requisitionDateOfGeneration) {
		this.requisitionDateOfGeneration = requisitionDateOfGeneration;
	}

	public Date getRequisitionExpectedDelivery() {
		return requisitionExpectedDelivery;
	}

	public void setRequisitionExpectedDelivery(Date requisitionExpectedDelivery) {
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

	public ProjectRequisition() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*@Override
	public String toString() {
		return "Requisition [requisitionId=" + requisitionId + ", requisitionStatus=" + requisitionStatus
				+ ", requisitionItems=" + requisitionItems + ", requisitionDateOfGeneration="
				+ requisitionDateOfGeneration + ", requisitionExpectedDelivery=" + requisitionExpectedDelivery
				+ ", requisitionRequestedBY=" + requisitionRequestedBY + ", requisitionJustification="
				+ requisitionJustification + ", requisitionCreatedDate=" + requisitionCreatedDate
				+ ", requisitionUpdatedDate=" + requisitionUpdatedDate + "]";
	}*/

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
		if (requisitionUpdatedDate == null) {
			if (other.requisitionUpdatedDate != null)
				return false;
		} else if (!requisitionUpdatedDate.equals(other.requisitionUpdatedDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProjectRequisition [requisitionId=" + requisitionId + ", requisitionStatus=" + requisitionStatus
				+ ", requisitionItems=" + requisitionItems + ", requisitionDateOfGeneration="
				+ requisitionDateOfGeneration + ", requisitionExpectedDelivery=" + requisitionExpectedDelivery
				+ ", requisitionRequestedBY=" + requisitionRequestedBY + ", project=" + project
				+ ", requisitionJustification=" + requisitionJustification + ", requisitionCreatedDate="
				+ requisitionCreatedDate + ", requisitionUpdatedDate=" + requisitionUpdatedDate + "]";
	}

	
	
	
	
}
