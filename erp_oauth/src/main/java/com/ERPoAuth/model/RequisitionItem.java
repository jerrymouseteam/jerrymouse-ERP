package com.ERPoAuth.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//@Entity
//@Table(name = "requisitionItems")
public class RequisitionItem implements Serializable {
	
//	
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long reuisitionItemId;
//	private boolean checked;
//	@OneToOne
//	@JoinColumn(name = "itemId")
//	private Item item;
//	@OneToOne
//	@JoinColumn(name = "gradeId")
//	private Grade grade;
//	private String usedFor;
//	private long quantity;
//	@OneToOne
//	@JoinColumn(name = "unitId")
//	private Unit unit;
//	@ManyToOne
//	@JoinColumn(name = "requisitionId")
//	private Requisition requisition;
//
//	
//	
//	
//	@Transient
//	private long itemId;
//	@Transient
//	private long gradeId;
//	@Transient
//	private long unitId;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date createdDate;
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date updatedDate;
//
//	public long getReuisitionItemId() {
//		return reuisitionItemId;
//	}
//
//	public void setReuisitionItemId(long reuisitionItemId) {
//		this.reuisitionItemId = reuisitionItemId;
//	}
//
//	public Item getItem() {
//		return item;
//	}
//
//	public void setItem(Item item) {
//		this.item = item;
//	}
//
//	public Grade getGrade() {
//		return grade;
//	}
//
//	public void setGrade(Grade grade) {
//		this.grade = grade;
//	}
//
//	public Unit getUnit() {
//		return unit;
//	}
//
//	public void setUnit(Unit unit) {
//		this.unit = unit;
//	}
//
//	@Override
//	public String toString() {
//		return "RequisitionItem [reuisitionItemId=" + reuisitionItemId + ", checked=" + checked + ", item=" + item
//				+ ", grade=" + grade + ", usedFor=" + usedFor + ", quantity=" + quantity + ", unit=" + unit
//				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
//	}
//
//	public RequisitionItem() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public RequisitionItem(Item item, Grade grade, Unit unit) {
//		super();
//		this.item = item;
//		this.grade = grade;
//		this.unit = unit;
//	}
//
//	public Requisition getRequisition() {
//		return requisition;
//	}
//
//	public void setRequisition(Requisition requisition) {
//		this.requisition = requisition;
//	}
//
//	public boolean isChecked() {
//		return checked;
//	}
//
//	public void setChecked(boolean checked) {
//		this.checked = checked;
//	}
//
//	public String getUsedFor() {
//		return usedFor;
//	}
//
//	public void setUsedFor(String usedFor) {
//		this.usedFor = usedFor;
//	}
//
//	public long getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(long quantity) {
//		this.quantity = quantity;
//	}
//
//	public long getItemId() {
//		return itemId;
//	}
//
//	public void setItemId(long itemId) {
//		this.itemId = itemId;
//	}
//
//	public long getGradeId() {
//		return gradeId;
//	}
//
//	public void setGradeId(long gradeId) {
//		this.gradeId = gradeId;
//	}
//
//	public long getUnitId() {
//		return unitId;
//	}
//
//	public void setUnitId(long unitId) {
//		this.unitId = unitId;
//	}
//
//	public Date getCreatedDate() {
//		return createdDate;
//	}
//
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//
//	public Date getUpdatedDate() {
//		return updatedDate;
//	}
//
//	public void setUpdatedDate(Date updatedDate) {
//		this.updatedDate = updatedDate;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + (checked ? 1231 : 1237);
//		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
//		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
//		result = prime * result + (int) (gradeId ^ (gradeId >>> 32));
//		result = prime * result + ((item == null) ? 0 : item.hashCode());
//		result = prime * result + (int) (itemId ^ (itemId >>> 32));
//		result = prime * result + (int) (quantity ^ (quantity >>> 32));
//		result = prime * result + ((requisition == null) ? 0 : requisition.hashCode());
//		result = prime * result + (int) (reuisitionItemId ^ (reuisitionItemId >>> 32));
//		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
//		result = prime * result + (int) (unitId ^ (unitId >>> 32));
//		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
//		result = prime * result + ((usedFor == null) ? 0 : usedFor.hashCode());
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
//		RequisitionItem other = (RequisitionItem) obj;
//		if (checked != other.checked)
//			return false;
//		if (createdDate == null) {
//			if (other.createdDate != null)
//				return false;
//		} else if (!createdDate.equals(other.createdDate))
//			return false;
//		if (grade == null) {
//			if (other.grade != null)
//				return false;
//		} else if (!grade.equals(other.grade))
//			return false;
//		if (gradeId != other.gradeId)
//			return false;
//		if (item == null) {
//			if (other.item != null)
//				return false;
//		} else if (!item.equals(other.item))
//			return false;
//		if (itemId != other.itemId)
//			return false;
//		if (quantity != other.quantity)
//			return false;
//		if (requisition == null) {
//			if (other.requisition != null)
//				return false;
//		} else if (!requisition.equals(other.requisition))
//			return false;
//		if (reuisitionItemId != other.reuisitionItemId)
//			return false;
//		if (unit == null) {
//			if (other.unit != null)
//				return false;
//		} else if (!unit.equals(other.unit))
//			return false;
//		if (unitId != other.unitId)
//			return false;
//		if (updatedDate == null) {
//			if (other.updatedDate != null)
//				return false;
//		} else if (!updatedDate.equals(other.updatedDate))
//			return false;
//		if (usedFor == null) {
//			if (other.usedFor != null)
//				return false;
//		} else if (!usedFor.equals(other.usedFor))
//			return false;
//		return true;
//	}
//
//	

}
