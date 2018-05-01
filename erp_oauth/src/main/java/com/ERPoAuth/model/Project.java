package com.ERPoAuth.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "APP_PROJECT")
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1344502805446658721L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private long project_id;

	public long getProject_id() {
		return project_id;
	}

	public void setProject_id(long project_id) {
		this.project_id = project_id;
	}

	@NotEmpty(message = "Project Name should not be empty")
	@NotNull
	@Column(name = "PROJECT_NAME", nullable = false)
	private String projectName;

	@Column(name = "SUB_DIVISION_NAME", nullable = true)
	private String subDivisionName;

	@NotNull(message = "Project should have a start date")
	@Column(name = "START_DATE", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private Date startDate;

	@NotNull(message = "Project should have an end date")
	@Column(name = "END_DATE", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private Date endDate;

	@NotEmpty(message = "Project Address should not be empty")
	@NotNull
	@Column(name = "PROJECT_ADDRESS", nullable = false)
	private String projectAddress;

	@Column(name = "REMARKS", nullable = true)
	private String remarks;

	@NotEmpty(message = "Contact Person Name for project should not be empty")
	@NotNull
	@Column(name = "CONTACT_PERSON_NAME", nullable = false)
	private String contactPersonName;

	@NotEmpty(message = "Contact Person Email for project should not be empty")
	@NotNull
	@Column(name = "CONTACT_PERSON_EMAIL", nullable = false)
	private String contactPersonEmail;

	@NotEmpty(message = "Contact Person Phone for project should not be empty")
	@NotNull
	@Column(name = "CONTACT_PERSON_PHONE", nullable = false)
	private String contactPersonPhone;

	@NotEmpty(message = "Client name for project should not be empty")
	@NotNull
	@Column(name = "PROJECT_CLIENT_NAME", nullable = false)
	private String projectClientName;

	@NotEmpty(message = "Client email for project should not be empty")
	@NotNull
	@Column(name = "PROJECT_CLIENT_EMAIL", nullable = false)
	private String projectClientEmail;

	@NotEmpty(message = "Client Contact Number for project should not be empty")
	@NotNull
	@Column(name = "PROJECT_CLIENT_PHONE", nullable = false)
	private String projectClientPhone;

	@NotEmpty(message = "Architect Name for project should not be empty")
	@NotNull
	@Column(name = "ARCHITECT_NAME", nullable = false)
	private String architectName;

	@NotEmpty(message = "Architect email for project should not be empty")
	@NotNull
	@Column(name = "ARCHITECT_EMAIL", nullable = false)
	private String architectEmail;

	@NotEmpty(message = "Architect Contact Number for project should not be empty")
	@NotNull
	@Column(name = "ARCHITECT_PHONE", nullable = false)
	private String architectPhone;

	@NotEmpty(message = "Structural Engineer Name for project should not be empty")
	@NotNull
	@Column(name = "STRUCTURAL_NAME", nullable = false)
	private String structuralName;

	@NotEmpty(message = "Structural Engineer Email for project should not be empty")
	@NotNull
	@Column(name = "STRUCTURAL_EMAIL", nullable = false)
	private String structuralEmail;

	@NotEmpty(message = "Structural Engineer Contact Number for project should not be empty")
	@NotNull
	@Column(name = "STRUCTURAL_PHONE", nullable = false)
	private String structuralPhone;

	@Column(name = "PROJECT_STATUS")
	private String projectStatus;

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

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (project_id ^ (project_id >>> 32));
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
		if (project_id != other.project_id)
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
