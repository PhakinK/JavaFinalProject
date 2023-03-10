package com.github.phakink.models;

/**
 * A class used for determines button's size.
 */
public class ButtonPropertities {

	private final int width, height;

	public ButtonPropertities(int width, int height) {

		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
