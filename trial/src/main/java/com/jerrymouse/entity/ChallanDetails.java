package com.jerrymouse.entity;

// Generated Dec 6, 2014 6:06:15 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ChallanDetails generated by hbm2java
 */
@Entity
@Table(name = "challan_details", catalog = "procurement")
public class ChallanDetails implements java.io.Serializable {

	private String chNo;
	private PurOrder purOrder;
	private String chnItem;
	private String delAddr;
	private Date delDt;
	private String itmGrd;
	private Double itmQty;
	private boolean authorizeSectEngg;
	private boolean authorizeLabTech;

	public ChallanDetails() {
	}

	public ChallanDetails(String chNo) {
		this.chNo = chNo;
	}

	public ChallanDetails(String chNo, PurOrder purOrder, String chnItem,
			String delAddr, Date delDt, String itmGrd, Double itmQty) {
		this.chNo = chNo;
		this.purOrder = purOrder;
		this.chnItem = chnItem;
		this.delAddr = delAddr;
		this.delDt = delDt;
		this.itmGrd = itmGrd;
		this.itmQty = itmQty;
	}

	@Id
	@Column(name = "ch_no", unique = true, nullable = false)
	public String getChNo() {
		return this.chNo;
	}

	public void setChNo(String chNo) {
		this.chNo = chNo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "po_no")
	public PurOrder getPurOrder() {
		return this.purOrder;
	}

	public void setPurOrder(PurOrder purOrder) {
		this.purOrder = purOrder;
	}

	@Column(name = "chn_item")
	public String getChnItem() {
		return this.chnItem;
	}

	public void setChnItem(String chnItem) {
		this.chnItem = chnItem;
	}

	@Column(name = "del_addr")
	public String getDelAddr() {
		return this.delAddr;
	}

	public void setDelAddr(String delAddr) {
		this.delAddr = delAddr;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "del_dt", length = 19)
	public Date getDelDt() {
		return this.delDt;
	}

	public void setDelDt(Date delDt) {
		this.delDt = delDt;
	}

	@Column(name = "itm_grd")
	public String getItmGrd() {
		return this.itmGrd;
	}

	public void setItmGrd(String itmGrd) {
		this.itmGrd = itmGrd;
	}

	@Column(name = "itm_qty", precision = 22, scale = 0)
	public Double getItmQty() {
		return this.itmQty;
	}

	public void setItmQty(Double itmQty) {
		this.itmQty = itmQty;
	}

	@Column(name = "authorize_sect_engg")
	public boolean isAuthorizeSectEngg() {
		return authorizeSectEngg;
	}

	public void setAuthorizeSectEngg(boolean authorizeSectEngg) {
		this.authorizeSectEngg = authorizeSectEngg;
	}

	@Column(name = "authorize_lab_tech")
	public boolean isAuthorizeLabTech() {
		return authorizeLabTech;
	}

	public void setAuthorizeLabTech(boolean authorizeLabTech) {
		this.authorizeLabTech = authorizeLabTech;
	}
}
