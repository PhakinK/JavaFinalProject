package com.github.phakink;

import com.github.phakink.registry.FlagEasyRegister;

public class Core {

	private static UserCache cache;

	public static void main(String[] args) {
		cache = new UserCache();

		FlagEasyRegister.getInstance().show(FlagEasyRegister.getInstance().randomQuiz());
	}

	public static UserCache getCache() {
		return cache;
	}
}
