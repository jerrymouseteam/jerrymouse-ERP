package com.ERP.constants;

public enum ProjectStatus {

	Open("Open"), Closed("Closed");

	private String projectStatus;

	private ProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

}
