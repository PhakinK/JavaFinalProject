package com.github.phakink.utils;

import com.github.phakink.models.GuessingPanel;
import com.github.phakink.registry.FlagRegister;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Main utility class with general function.
 */
public final class Common {

	private Common() {}

	/**
	 * Convert anythings that implements {@link Iterable} to {@link ArrayList}
	 *
	 * @param it
	 * @return
	 * @param <T>
	 */
	public static <T> List<T> toList(final Iterable<T> it) {
		final List<T> list = new ArrayList<>();

		if (it != null)
			it.forEach(el -> {
				if (el != null)
					list.add(el);
			});

		return list;
	}

	/**
	 * @deprecated
	 * Using {@link FlagRegister#getInstance()#setState(GuessingPanel, boolean)} instead.
	 */
	@Deprecated
	public static void setState(GuessingPanel panel , boolean state) {

		FlagRegister.getInstance().setState(panel , state);
	}

	/**
	 * @deprecated
	 * Using {@link FlagRegister#getInstance()#clearAllModeState()} instead.
	 */
	@Deprecated
	public static void clearAllModeState() {
		FlagRegister.getInstance().clearState();
	}

	/**
	 * Make a GUI spawn on center of screen.
	 *
	 * @param objFrame
	 */
	public static void centeredFrame(JFrame objFrame) {
		Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
		int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
		objFrame.setLocation(iCoordX, iCoordY);
	}

	/**
	 * Get currently date time in String.
	 *
	 * @return
	 */
	public static String getFormattedDate() {
		final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

		return dateFormat.format(System.currentTimeMillis());
	}
}
