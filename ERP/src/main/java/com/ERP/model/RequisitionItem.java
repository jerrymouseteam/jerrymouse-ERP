package com.ERP.model;

import java.io.Serializable;
import java.util.Date;



public class RequisitionItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long requisitionItemId;

	private boolean checked;

	private long quantity;

	private String usedFor;

	private long itemId;
	private long gradeId;
	private long unitId;

	private Item item;

	private Grade grade;

	private Unit unit;

	private ProjectRequisition projectRequisition;

	private Date createdDate;

	private Date updatedDate;
	
	

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	
	

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getUsedFor() {
		return usedFor;
	}

	public void setUsedFor(String usedFor) {
		this.usedFor = usedFor;
	}

	public long getGradeId() {
		return gradeId;
	}

	public void setGradeId(long gradeId) {
		this.gradeId = gradeId;
	}

	public long getUnitId() {
		return unitId;
	}

	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getRequisitionItemId() {
		return requisitionItemId;
	}

	public void setRequisitionItemId(long requisitionItemId) {
		this.requisitionItemId = requisitionItemId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	

	public ProjectRequisition getProjectRequisition() {
		return projectRequisition;
	}

	public void setProjectRequisition(ProjectRequisition projectRequisition) {
		this.projectRequisition = projectRequisition;
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

	public RequisitionItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (checked ? 1231 : 1237);
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + (int) (gradeId ^ (gradeId >>> 32));
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + (int) (itemId ^ (itemId >>> 32));
		result = prime * result + ((projectRequisition == null) ? 0 : projectRequisition.hashCode());
		result = prime * result + (int) (quantity ^ (quantity >>> 32));
		result = prime * result + (int) (requisitionItemId ^ (requisitionItemId >>> 32));
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		result = prime * result + (int) (unitId ^ (unitId >>> 32));
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		result = prime * result + ((usedFor == null) ? 0 : usedFor.hashCode());
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
		RequisitionItem other = (RequisitionItem) obj;
		if (checked != other.checked)
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (gradeId != other.gradeId)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (itemId != other.itemId)
			return false;
		if (projectRequisition == null) {
			if (other.projectRequisition != null)
				return false;
		} else if (!projectRequisition.equals(other.projectRequisition))
			return false;
		if (quantity != other.quantity)
			return false;
		if (requisitionItemId != other.requisitionItemId)
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		if (unitId != other.unitId)
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		if (usedFor == null) {
			if (other.usedFor != null)
				return false;
		} else if (!usedFor.equals(other.usedFor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RequisitionItem [requisitionItemId=" + requisitionItemId + ", checked=" + checked + ", quantity="
				+ quantity + ", usedFor=" + usedFor + ", itemId=" + itemId + ", gradeId=" + gradeId + ", unitId="
				+ unitId + ", item=" + item + ", grade=" + grade + ", unit=" + unit + ", projectRequisition=" + projectRequisition
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
	

	
}
