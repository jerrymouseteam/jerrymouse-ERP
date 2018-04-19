package com.ERPoAuth.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="units")
public class Unit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long unitId;
	@Column(unique=true)
	private String unitName;
	private String unitDesc;
	
	@ManyToMany(mappedBy="units")
    private List<Grade> grades = new ArrayList<>();
	
	public long getUnitId() {
		return unitId;
	}
	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getUnitDesc() {
		return unitDesc;
	}
	public void setUnitDesc(String unitDesc) {
		this.unitDesc = unitDesc;
	}
	
	
	public List<Grade> getGrades() {
		return grades;
	}
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grades == null) ? 0 : grades.hashCode());
		result = prime * result + ((unitDesc == null) ? 0 : unitDesc.hashCode());
		result = prime * result + (int) (unitId ^ (unitId >>> 32));
		result = prime * result + ((unitName == null) ? 0 : unitName.hashCode());
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
		Unit other = (Unit) obj;
		if (grades == null) {
			if (other.grades != null)
				return false;
		} else if (!grades.equals(other.grades))
			return false;
		if (unitDesc == null) {
			if (other.unitDesc != null)
				return false;
		} else if (!unitDesc.equals(other.unitDesc))
			return false;
		if (unitId != other.unitId)
			return false;
		if (unitName == null) {
			if (other.unitName != null)
				return false;
		} else if (!unitName.equals(other.unitName))
			return false;
		return true;
	}
	public Unit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Unit(String unitName, String unitDesc) {
		super();
		this.unitName = unitName;
		this.unitDesc = unitDesc;
	}
	@Override
	public String toString() {
		return "Unit [unitId=" + unitId + ", unitName=" + unitName + ", unitDesc=" + unitDesc + "]";
	}
	
	

}
