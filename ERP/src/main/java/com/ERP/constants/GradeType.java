package com.ERP.constants;

public enum GradeType {

	M20("M20"), M25("M25"), M30("M30"), M35("M35"), M40("M40"), M45("M45"), M50(
			"M50"), PPC("PPC"), OPC33("OPC33"), OPC43("OPC43"), OPC53("OPC53"), M1(
			"M1"), M2("M2"), d6mm("d6mm"), d8mm("d8mm"), d12mm("d12mm"), d16mm(
			"d16mm"), d20mm("d20mm"), d25mm("d25mm"), d30mm("d30mm"), inch4(
			"inch4"), inch6("inch6"), inch9("inch9"), N_A("N/A"), FE415("FE415"), FE500(
			"FE500");

	private String gradeType;

	private GradeType(String gradeType) {
		this.gradeType = gradeType;
	}

	public String getGradeType() {
		return gradeType;
	}

}
