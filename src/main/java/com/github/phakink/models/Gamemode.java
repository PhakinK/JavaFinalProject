package com.github.phakink.models;

/**
 * Enumeration used for determines difficulty of quiz.
 */
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
