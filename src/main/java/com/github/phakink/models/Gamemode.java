package com.github.phakink.models;

public enum Gamemode {

	EASY("Easy"),
	MEDIUM("Medium"),
	HARD("Hard");


	private final String abbreviation;

	Gamemode(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation() {
		return abbreviation;
	}
}
