package com.github.phakink;

import java.io.*;

public class UserCache implements Serializable {

	private int point;

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
		this.point -= point;
	}

}
