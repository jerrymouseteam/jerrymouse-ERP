package com.ERP.constants;

public enum UserStatus {

	Active("Active"), Inactive("Inactive");

	private String userStatus;

	private UserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserStatus() {
		return userStatus;
	}

}
