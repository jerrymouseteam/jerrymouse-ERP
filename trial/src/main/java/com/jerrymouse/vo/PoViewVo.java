package com.jerrymouse.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PoViewVo {

	@Id
	private Long poNo;
	private Long challanNo;
	private Date delDt;
	private String delAddress;
	private String upstream;
	private Double itemQty;
	private Double itemAmnt;
	private String item;
	private String itemGrade;
	private String itemUnit;

	public PoViewVo() {
		super();
	}

	public Long getPoNo() {
		return poNo;
	}

	public void setPoNo(Long poNo) {
		this.poNo = poNo;
	}

	public Long getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(Long challanNo) {
		this.challanNo = challanNo;
	}

	public Date getDelDt() {
		return delDt;
	}

	public void setDelDt(Date delDt) {
		this.delDt = delDt;
	}

	public String getDelAddress() {
		return delAddress;
	}

	public void setDelAddress(String delAddress) {
		this.delAddress = delAddress;
	}

	public String getUpstream() {
		return upstream;
	}

	public void setUpstream(String upstream) {
		this.upstream = upstream;
	}

	public Double getItemQty() {
		return itemQty;
	}

	public void setItemQty(Double itemQty) {
		this.itemQty = itemQty;
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

	public Double getItemAmnt() {
		return itemAmnt;
	}

	public void setItemAmnt(Double itemAmnt) {
		this.itemAmnt = itemAmnt;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

}
