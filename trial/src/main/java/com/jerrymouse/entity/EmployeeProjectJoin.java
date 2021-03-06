package com.jerrymouse.entity;

// Generated Dec 6, 2014 6:06:15 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * EmployeeProjectJoin generated by hbm2java
 */
@Entity
@Table(name = "employee_project_join", catalog = "procurement")
public class EmployeeProjectJoin implements java.io.Serializable {

	private Integer id;

	private EmpDetails empDetails;
	private Project project;

	public EmployeeProjectJoin() {
	}

	public EmployeeProjectJoin(EmpDetails empDetails, Project project) {
		this.empDetails = empDetails;
		this.project = project;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_nm")
	public EmpDetails getEmpDetails() {
		return this.empDetails;
	}

	public void setEmpDetails(EmpDetails empDetails) {
		this.empDetails = empDetails;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id")
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((empDetails == null) ? 0 : empDetails.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		EmployeeProjectJoin other = (EmployeeProjectJoin) obj;
		if (empDetails == null) {
			if (other.empDetails != null)
				return false;
		} else if (!empDetails.equals(other.empDetails))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
