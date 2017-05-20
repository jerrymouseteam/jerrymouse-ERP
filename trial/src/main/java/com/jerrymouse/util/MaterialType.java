package com.jerrymouse.util;

public enum MaterialType {

	Cement("Cement"), RMC("RMC"), Steel("Steel"), Blocks("Blocks"), ConventionalShuttering(
			"ConventionalShuttering"), MivanShuttering("MivanShuttering"), Aggregates(
			"Aggregates"), Sand("Sand");

	private String materialType;

	private MaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getMaterialType() {
		return materialType;
	}
}
