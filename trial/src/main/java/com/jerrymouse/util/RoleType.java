package com.jerrymouse.util;

public enum RoleType {

	Admin("Admin"), Director("Director"), SITE_ENGG_PROFILE("Site Engineer"), Sector_Engineer(
			"Sector Engineer"), Project_Manager("Project Manager"), Storekeeper(
			"Storekeeper"), Purchase("Purchase Department"), LAB_TECHNICIAN(
			"Lab Technician");

	private String roleType;

	private RoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getRoleType() {
		return roleType;
	}

}
