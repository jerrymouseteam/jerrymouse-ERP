package com.ERP.model;

import java.io.Serializable;

public class Item implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long itemId;
	private String itemName;
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
	
	public Item(long itemId, String itemName) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
