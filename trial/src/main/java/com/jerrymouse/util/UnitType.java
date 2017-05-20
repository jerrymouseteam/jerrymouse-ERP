package com.jerrymouse.util;

public enum UnitType {

	cum("cum"), Mt("MT"), bags("bags"), litre("litre"), sqm("sqm"), brass(
			"brass"), nos("nos");

	private String unitType;

	private UnitType(String unitType) {
		this.unitType = unitType;
	}

	public String getUnitType() {
		return unitType;
	}

}
