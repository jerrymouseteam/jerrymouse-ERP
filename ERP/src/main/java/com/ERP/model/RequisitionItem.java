package com.ERP.model;

import java.io.Serializable;
import java.util.List;

public class RequisitionItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long requisitionLineItemId;
	private boolean checked;
	// private List<String> items;
	// private List<String> grades;
	// private List<String> quantities;
	private String quantity;
	// private List<String> units;
	private String usedFor;

	// private List<Item> itemsList;

	private long itemId;
	private long gradeId;
	private long unitId;

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	

	public long getRequisitionLineItemId() {
		return requisitionLineItemId;
	}

	public void setRequisitionLineItemId(long requisitionLineItemId) {
		this.requisitionLineItemId = requisitionLineItemId;
	}

	
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
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

	@Override
	public String toString() {
		return "RequisitionItem [requisitionLineItemId=" + requisitionLineItemId + ", checked=" + checked
				+ ", quantity=" + quantity + ", usedFor=" + usedFor + ", itemId=" + itemId + ", gradeId=" + gradeId
				+ ", unitId=" + unitId + "]";
	}

	
	

}
