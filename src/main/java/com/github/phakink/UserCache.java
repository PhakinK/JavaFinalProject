package com.github.phakink;

public class UserCache {

	/**
	 * The class which used for assigned the score to the user.
	 */

	private int point = 0;

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * Increasing user point by plus the old score through int in param
	 * @param point
	 */
	public void increasePoint(int point) {
		this.point += point;
	}

	public void decreasePoint(int point) {
		if (this.point - point < 0)
			return;

		this.point -= point;
	}

}
