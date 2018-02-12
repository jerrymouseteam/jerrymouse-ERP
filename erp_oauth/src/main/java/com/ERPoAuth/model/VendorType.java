package com.ERPoAuth.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendor_types")
public class VendorType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long vendor_type_id;
	@Column(unique=true)
	private String vendor_type_name;
	public VendorType(String vendor_type_name) {
		super();
		this.vendor_type_name = vendor_type_name;
	}
	public VendorType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getVendor_type_id() {
		return vendor_type_id;
	}
	public void setVendor_type_id(long vendor_type_id) {
		this.vendor_type_id = vendor_type_id;
	}
	public String getVendor_type_name() {
		return vendor_type_name;
	}
	public void setVendor_type_name(String vendor_type_name) {
		this.vendor_type_name = vendor_type_name;
	}
	
	
	
	
	

}
