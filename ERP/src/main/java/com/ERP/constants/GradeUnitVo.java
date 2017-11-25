package com.ERP.constants;

import java.util.ArrayList;
import java.util.List;

public class GradeUnitVo {

	List<String> gradeType = new ArrayList<String>();

	List<String> unitType = new ArrayList<String>();

	public List<String> getGradeType() {
		return gradeType;
	}

	public void setGradeType(List<String> gradeType) {
		this.gradeType = gradeType;
	}

	public List<String> getUnitType() {
		return unitType;
	}

	public void setUnitType(List<String> unitType) {
		this.unitType = unitType;
	}

}
