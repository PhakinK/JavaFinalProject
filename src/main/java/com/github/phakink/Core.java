package com.github.phakink;

import com.github.phakink.panel.menu.ModeSelectionPanel;

public class Core {

	private static UserCache cache;

	public static void main(String[] args) {
		cache = new UserCache();

		new ModeSelectionPanel().setVisible(true);
	}

	public static UserCache getCache() {
		return cache;
	}
}
