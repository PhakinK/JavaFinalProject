package com.github.phakink;

import com.github.phakink.panel.MainPanel;
import com.github.phakink.utils.Common;

import java.awt.*;

public class Core {

	private static UserCache cache;

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			try {
				cache = new UserCache();

				MainPanel frame = new MainPanel();

				Common.centeredFrame(frame);
				frame.setVisible(true);

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public static UserCache getCache() {
		return cache;
	}
}
