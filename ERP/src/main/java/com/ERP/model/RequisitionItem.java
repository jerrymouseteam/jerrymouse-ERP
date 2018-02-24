package com.ERP.model;

import java.io.Serializable;
import java.util.List;

public class RequisitionItem implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long requisitionItemId;
	private boolean checked;
	private List<String> items;
	private List<String> grades;
	private List<String> quantities;
	private List<String> units;
	private String usedFor;
	
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public long getRequisitionItemId() {
		return requisitionItemId;
	}
	public void setRequisitionItemId(long requisitionItemId) {
		this.requisitionItemId = requisitionItemId;
	}
	public List<String> getItems() {
		return items;
	}
	public void setItems(List<String> items) {
		this.items = items;
	}
	public List<String> getGrades() {
		return grades;
	}
	public void setGrades(List<String> grades) {
		this.grades = grades;
	}
	public List<String> getQuantities() {
		return quantities;
	}
	public void setQuantities(List<String> quantities) {
		this.quantities = quantities;
	}
	public List<String> getUnits() {
		return units;
	}
	public void setUnits(List<String> units) {
		this.units = units;
	}
	public String getUsedFor() {
		return usedFor;
	}
	public void setUsedFor(String usedFor) {
		this.usedFor = usedFor;
	}
	@Override
	public String toString() {
		return "RequisitionItem [requisitionItemId=" + requisitionItemId + ", checked=" + checked + ", items=" + items
				+ ", grades=" + grades + ", quantities=" + quantities + ", units=" + units + ", usedFor=" + usedFor
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (checked ? 1231 : 1237);
		result = prime * result + ((grades == null) ? 0 : grades.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((quantities == null) ? 0 : quantities.hashCode());
		result = prime * result + (int) (requisitionItemId ^ (requisitionItemId >>> 32));
		result = prime * result + ((units == null) ? 0 : units.hashCode());
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
		if (grades == null) {
			if (other.grades != null)
				return false;
		} else if (!grades.equals(other.grades))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (quantities == null) {
			if (other.quantities != null)
				return false;
		} else if (!quantities.equals(other.quantities))
			return false;
		if (requisitionItemId != other.requisitionItemId)
			return false;
		if (units == null) {
			if (other.units != null)
				return false;
		} else if (!units.equals(other.units))
			return false;
		if (usedFor == null) {
			if (other.usedFor != null)
				return false;
		} else if (!usedFor.equals(other.usedFor))
			return false;
		return true;
	}
	
	
	
	
	
	
}
