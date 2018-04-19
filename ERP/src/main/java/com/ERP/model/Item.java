package com.ERP.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Item implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long itemId;
	
	private String itemName;
	private String itemDesc;
	
	
	
	private List<Grade> grades=new ArrayList<>();
	
	
	
	
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public List<Grade> getGrades() {
		return grades;
	}
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
	
	
	
	public Item(long itemId, String itemName) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", grades=" + grades
				+ "]";
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(String itemName, String itemDesc, List<Grade> grades) {
		super();
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.grades = grades;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grades == null) ? 0 : grades.hashCode());
		result = prime * result + ((itemDesc == null) ? 0 : itemDesc.hashCode());
		result = prime * result + (int) (itemId ^ (itemId >>> 32));
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
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
		Item other = (Item) obj;
		if (grades == null) {
			if (other.grades != null)
				return false;
		} else if (!grades.equals(other.grades))
			return false;
		if (itemDesc == null) {
			if (other.itemDesc != null)
				return false;
		} else if (!itemDesc.equals(other.itemDesc))
			return false;
		if (itemId != other.itemId)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		return true;
	}
	
	

}
