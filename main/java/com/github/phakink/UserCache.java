package com.github.phakink;

public class UserCache {

	private int point = 0;

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public void increasePoint(int point) {
		this.point += point;
	}

	public void decreasePoint(int point) {
		if (this.point - point < 1)
			return;

		this.point -= point;
	}

}
