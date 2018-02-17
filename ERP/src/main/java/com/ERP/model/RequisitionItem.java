package com.ERP.model;

import java.io.Serializable;
import java.util.List;

public class RequisitionItem implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sr;
	private List<String> items;
	private List<String> grades;
	private List<String> quantities;
	private List<String> units;
	private String usedFor;
	public int getSr() {
		return sr;
	}
	public void setSr(int sr) {
		this.sr = sr;
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
		return "RequisitionItem [sr=" + sr + ", items=" + items + ", grades=" + grades + ", quantities=" + quantities
				+ ", units=" + units + ", usedFor=" + usedFor + "]";
	}
	
	
	
}
