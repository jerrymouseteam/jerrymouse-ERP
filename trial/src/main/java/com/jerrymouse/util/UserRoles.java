package com.jerrymouse.util;

public enum UserRoles {
	HR_Admin("HR/Admin"), Director("Director"), Site_Engineer("Site_Engineer"), Sector_Engineer(
			"Sector_Engineer"), Contractor("Contractor"), Purchase_Engineer(
			"Purchase_Engineer"), Lab_Technician("Lab_Technician"), Store_Keeper(
			"Store_Keeper"), Accountant("Accountant");

	private String user;

	private UserRoles(String user) {
		this.user = user;
	}

	public String getUserRoles() {
		return user;
	}

}
