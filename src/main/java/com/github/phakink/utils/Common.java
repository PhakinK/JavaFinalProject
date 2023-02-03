package com.github.phakink.utils;

import com.github.phakink.models.Gamemode;
import com.github.phakink.models.GuessingPanel;
import com.github.phakink.registry.FlagEasyRegister;
import com.github.phakink.registry.FlagHardRegister;
import com.github.phakink.registry.FlagMediumRegister;

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

	public static void setState(Gamemode gamemode, GuessingPanel panel , boolean state) {

		switch (gamemode) {
			case EASY:
				FlagEasyRegister.getInstance().setState(panel , state);
				break;
			case MEDIUM:
				FlagMediumRegister.getInstance().setState(panel , state);
				break;
			case HARD:
				FlagHardRegister.getInstance().setState(panel , state);
				break;
		}

	}

	public static void clearAllModeState() {
		FlagEasyRegister.getInstance().clearState();
		FlagMediumRegister.getInstance().clearState();
		FlagHardRegister.getInstance().clearState();
	}
}
