package com.ERPoAuth.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "APP_PROJECT")
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1344502805446658721L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="project_id")
	private Integer project_id;

	@NotNull
	@Column(name = "PROJECT_NAME", nullable = false)
	private String projectName;

	@Column(name = "SUB_DIVISION_NAME", nullable = true)
	private String subDivisionName;

	@NotNull
	@Column(name = "START_DATE", nullable = false)
	private Date startDate;

	@NotNull
	@Column(name = "END_DATE", nullable = false)
	private Date endDate;

	@NotNull
	@Column(name = "PROJECT_ADDRESS", nullable = false)
	private String projectAddress;

	@Column(name = "REMARKS", nullable = true)
	private String remarks;

	@NotNull
	@Column(name = "CONTACT_PERSON_NAME", nullable = false)
	private String contactPersonName;

	@NotNull
	@Column(name = "CONTACT_PERSON_EMAIL", nullable = false)
	private String contactPersonEmail;

	@NotNull
	@Column(name = "CONTACT_PERSON_PHONE", nullable = false)
	private String contactPersonPhone;

	@NotNull
	@Column(name = "PROJECT_CLIENT_NAME", nullable = false)
	private String projectClientName;

	@NotNull
	@Column(name = "PROJECT_CLIENT_EMAIL", nullable = false)
	private String projectClientEmail;

	@NotNull
	@Column(name = "PROJECT_CLIENT_PHONE", nullable = false)
	private String projectClientPhone;

	@NotNull
	@Column(name = "ARCHITECT_NAME", nullable = false)
	private String architectName;

	@NotNull
	@Column(name = "ARCHITECT_EMAIL", nullable = false)
	private String architectEmail;

	@NotNull
	@Column(name = "ARCHITECT_PHONE", nullable = false)
	private String architectPhone;

	@NotNull
	@Column(name = "STRUCTURAL_NAME", nullable = false)
	private String structuralName;

	@NotNull
	@Column(name = "STRUCTURAL_EMAIL", nullable = false)
	private String structuralEmail;

	@NotNull
	@Column(name = "STRUCTURAL_PHONE", nullable = false)
	private String structuralPhone;

	public Integer getProject_id() {
		return project_id;
	}

	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSubDivisionName() {
		return subDivisionName;
	}

	public void setSubDivisionName(String subDivisionName) {
		this.subDivisionName = subDivisionName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getProjectAddress() {
		return projectAddress;
	}

	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPersonEmail() {
		return contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}

	public String getContactPersonPhone() {
		return contactPersonPhone;
	}

	public void setContactPersonPhone(String contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}

	public String getProjectClientName() {
		return projectClientName;
	}

	public void setProjectClientName(String projectClientName) {
		this.projectClientName = projectClientName;
	}

	public String getProjectClientEmail() {
		return projectClientEmail;
	}

	public void setProjectClientEmail(String projectClientEmail) {
		this.projectClientEmail = projectClientEmail;
	}

	public String getProjectClientPhone() {
		return projectClientPhone;
	}

	public void setProjectClientPhone(String projectClientPhone) {
		this.projectClientPhone = projectClientPhone;
	}

	public String getArchitectName() {
		return architectName;
	}

	public void setArchitectName(String architectName) {
		this.architectName = architectName;
	}

	public String getArchitectEmail() {
		return architectEmail;
	}

	public void setArchitectEmail(String architectEmail) {
		this.architectEmail = architectEmail;
	}

	public String getArchitectPhone() {
		return architectPhone;
	}

	public void setArchitectPhone(String architectPhone) {
		this.architectPhone = architectPhone;
	}

	public String getStructuralName() {
		return structuralName;
	}

	public void setStructuralName(String structuralName) {
		this.structuralName = structuralName;
	}

	public String getStructuralEmail() {
		return structuralEmail;
	}

	public void setStructuralEmail(String structuralEmail) {
		this.structuralEmail = structuralEmail;
	}

	public String getStructuralPhone() {
		return structuralPhone;
	}

	public void setStructuralPhone(String structuralPhone) {
		this.structuralPhone = structuralPhone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((project_id == null) ? 0 : project_id.hashCode());
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
		Project other = (Project) obj;
		if (project_id == null) {
			if (other.project_id != null)
				return false;
		} else if (!project_id.equals(other.project_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + project_id + ", projectName="
				+ projectName + ", subDivisionName=" + subDivisionName
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", projectAddress=" + projectAddress + ", remarks=" + remarks
				+ ", contactPersonName=" + contactPersonName
				+ ", contactPersonEmail=" + contactPersonEmail
				+ ", contactPersonPhone=" + contactPersonPhone
				+ ", projectClientName=" + projectClientName
				+ ", projectClientEmail=" + projectClientEmail
				+ ", projectClientPhone=" + projectClientPhone
				+ ", architectName=" + architectName + ", architectEmail="
				+ architectEmail + ", architectPhone=" + architectPhone
				+ ", structuralName=" + structuralName + ", structuralEmail="
				+ structuralEmail + ", structuralPhone=" + structuralPhone
				+ "]";
	}

	
	
}
