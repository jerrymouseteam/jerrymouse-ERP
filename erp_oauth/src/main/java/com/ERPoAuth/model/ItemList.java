package com.ERPoAuth.model;

//Generated Dec 6, 2014 6:06:15 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ItemList generated by hbm2java
 */
@Entity
@Table(name = "APP_ITEM_LIST")
public class ItemList implements java.io.Serializable {

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "itemCount", column = @Column(name = "ITEM_COUNT", nullable = false)),
			@AttributeOverride(name = "itemId", column = @Column(name = "ITEM_ID", nullable = false)) })
	private ItemListId id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ITEM_ID", referencedColumnName = "REQ_NO", nullable = false, insertable = false, updatable = false)
	private Requisition requisition;

	@Column(name = "ITEM")
	private String item;

	@Column(name = "ITEM_GRD")
	private String itemGrd;

	@Column(name = "ITEM_QTY", precision = 22, scale = 0)
	private Double itemQty;

	@Column(name = "UNIT")
	private String unit;

	@Column(name = "USED_FOR")
	private String usedFor;

	public ItemList() {
	}

	public ItemList(ItemListId id, Requisition requisition) {
		this.id = id;
		this.requisition = requisition;
	}

	public ItemList(ItemListId id, Requisition requisition, String item,
			String itemGrd, Double itemQty, String unit) {
		this.id = id;
		this.requisition = requisition;
		this.item = item;
		this.itemGrd = itemGrd;
		this.itemQty = itemQty;
		this.unit = unit;
	}

	public ItemListId getId() {
		return this.id;
	}

	public void setId(ItemListId id) {
		this.id = id;
	}

	public Requisition getRequisition() {
		return this.requisition;
	}

	public void setRequisition(Requisition requisition) {
		this.requisition = requisition;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItemGrd() {
		return this.itemGrd;
	}

	public void setItemGrd(String itemGrd) {
		this.itemGrd = itemGrd;
	}

	public Double getItemQty() {
		return this.itemQty;
	}

	public void setItemQty(Double itemQty) {
		this.itemQty = itemQty;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUsedFor() {
		return this.usedFor;
	}

	public void setUsedFor(String usedFor) {
		this.usedFor = usedFor;
	}

}
