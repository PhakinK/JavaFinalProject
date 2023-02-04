package com.github.phakink.utils;

import com.github.phakink.models.Gamemode;
import com.github.phakink.models.GuessingPanel;
import com.github.phakink.registry.FlagRegister;

import java.util.ArrayList;
import java.util.List;

public final class Common {

	private Common() {}

	public static <T> List<T> toList(final Iterable<T> it) {
		final List<T> list = new ArrayList<>();

		if (it != null)
			it.forEach(el -> {
				if (el != null)
					list.add(el);
			});

		return list;
	}

	public static void setState(GuessingPanel panel , boolean state) {

		FlagRegister.getInstance().setState(panel , state);
	}

	public static void clearAllModeState() {
		FlagRegister.getInstance().clearState();
	}
}
