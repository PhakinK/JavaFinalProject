package com.github.phakink;

import com.github.phakink.panel.ModeSelectionPanel;

public class Core {

	private static UserCache cache;
	private static ModeSelectionPanel modeSelectionPanel;


	public static void main(String[] args) {
		cache = new UserCache();

		modeSelectionPanel = new ModeSelectionPanel();
		modeSelectionPanel.setVisible(true);
	}

	public static UserCache getCache() {
		return cache;
	}

	public static ModeSelectionPanel getModeSelectionPanel() {
		return modeSelectionPanel;
	}
}
