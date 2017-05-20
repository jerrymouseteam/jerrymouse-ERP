package com.jerrymouse.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SearchUserVo {

	@Id
	private String empName;
	private String empUserNm;
	private String empRole;
	private String empProj;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpUserNm() {
		return empUserNm;
	}

	public void setEmpUserNm(String empUserNm) {
		this.empUserNm = empUserNm;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public String getEmpProj() {
		return empProj;
	}

	public void setEmpProj(String empProj) {
		this.empProj = empProj;
	}

}
