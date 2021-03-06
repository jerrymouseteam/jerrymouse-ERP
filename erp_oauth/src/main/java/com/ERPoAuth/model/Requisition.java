package com.ERPoAuth.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Requisition generated by hbm2java
 */
@Entity
@Table(name = "APP_REQUISITION")
public class Requisition implements java.io.Serializable {

	@Id
	@Column(name = "REQ_NO", unique = true, nullable = false)
	private Long reqNo;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "REQ_PROJ_ID", referencedColumnName = "project_id")
	private Project project;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_GEN", length = 19)
	private Date dateGen;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DEL_DT", length = 19)
	private Date delDt;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPECTED_DT", length = 19)
	private Date expectedDt;

	@Column(name = "REQ_STS")
	private String reqSts;

	@Column(name = "AUTHORIZE_SECT_ENGG")
	private boolean authorizeSectEngg;

	@NotNull
	@Column(name = "REQUESTED_BY")
	private String requestedBy;

	@NotNull
	@Column(name = "JUSTIFICATION")
	private String justification;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "requisition", cascade = CascadeType.ALL)
	private Set<ItemList> itemLists = new HashSet<ItemList>(0);

	public Requisition() {
	}

	public Requisition(Project project, Date dateGen, Date delDt,
			Date expectedDt, String reqSts, Set<ItemList> itemLists) {
		this.project = project;
		this.dateGen = dateGen;
		this.delDt = delDt;
		this.expectedDt = expectedDt;
		this.reqSts = reqSts;
		this.itemLists = itemLists;
	}

	public Long getReqNo() {
		return reqNo;
	}

	public void setReqNo(Long reqNo) {
		this.reqNo = reqNo;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getDateGen() {
		return dateGen;
	}

	public void setDateGen(Date dateGen) {
		this.dateGen = dateGen;
	}

	public Date getDelDt() {
		return delDt;
	}

	public void setDelDt(Date delDt) {
		this.delDt = delDt;
	}

	public Date getExpectedDt() {
		return expectedDt;
	}

	public void setExpectedDt(Date expectedDt) {
		this.expectedDt = expectedDt;
	}

	public String getReqSts() {
		return reqSts;
	}

	public void setReqSts(String reqSts) {
		this.reqSts = reqSts;
	}

	public boolean isAuthorizeSectEngg() {
		return authorizeSectEngg;
	}

	public void setAuthorizeSectEngg(boolean authorizeSectEngg) {
		this.authorizeSectEngg = authorizeSectEngg;
	}

	public String getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public Set<ItemList> getItemLists() {
		return itemLists;
	}

	public void setItemLists(Set<ItemList> itemLists) {
		this.itemLists = itemLists;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (authorizeSectEngg ? 1231 : 1237);
		result = prime * result + ((dateGen == null) ? 0 : dateGen.hashCode());
		result = prime * result + ((delDt == null) ? 0 : delDt.hashCode());
		result = prime * result
				+ ((expectedDt == null) ? 0 : expectedDt.hashCode());
		result = prime * result
				+ ((itemLists == null) ? 0 : itemLists.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((reqNo == null) ? 0 : reqNo.hashCode());
		result = prime * result + ((reqSts == null) ? 0 : reqSts.hashCode());
		result = prime * result
				+ ((requestedBy == null) ? 0 : requestedBy.hashCode());
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
		Requisition other = (Requisition) obj;
		if (authorizeSectEngg != other.authorizeSectEngg)
			return false;
		if (dateGen == null) {
			if (other.dateGen != null)
				return false;
		} else if (!dateGen.equals(other.dateGen))
			return false;
		if (delDt == null) {
			if (other.delDt != null)
				return false;
		} else if (!delDt.equals(other.delDt))
			return false;
		if (expectedDt == null) {
			if (other.expectedDt != null)
				return false;
		} else if (!expectedDt.equals(other.expectedDt))
			return false;
		if (itemLists == null) {
			if (other.itemLists != null)
				return false;
		} else if (!itemLists.equals(other.itemLists))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (reqNo == null) {
			if (other.reqNo != null)
				return false;
		} else if (!reqNo.equals(other.reqNo))
			return false;
		if (reqSts == null) {
			if (other.reqSts != null)
				return false;
		} else if (!reqSts.equals(other.reqSts))
			return false;
		if (requestedBy == null) {
			if (other.requestedBy != null)
				return false;
		} else if (!requestedBy.equals(other.requestedBy))
			return false;
		return true;
	}

}
