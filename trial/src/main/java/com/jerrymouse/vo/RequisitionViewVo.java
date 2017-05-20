package com.jerrymouse.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RequisitionViewVo {

	@Id
	private Long reqNo;
	private String dateGen;
	private String expectedDt;
	private String requestedBy;
	private String status;
	private String item;
	private String itemGrade;
	private String itemUnit;
	private Double itemQty;

	public Double getItemQty() {
		return itemQty;
	}

	public void setItemQty(Double itemQty) {
		this.itemQty = itemQty;
	}

	public RequisitionViewVo() {
		super();
	}

	public Long getReqNo() {
		return reqNo;
	}

	public void setReqNo(Long reqNo) {
		this.reqNo = reqNo;
	}

	public String getDateGen() {
		return dateGen;
	}

	public void setDateGen(String dateGen) {
		this.dateGen = dateGen;
	}

	public String getExpectedDt() {
		return expectedDt;
	}

	public void setExpectedDt(String expectedDt) {
		this.expectedDt = expectedDt;
	}

	public String getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItemGrade() {
		return itemGrade;
	}

	public void setItemGrade(String itemGrade) {
		this.itemGrade = itemGrade;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}
}
