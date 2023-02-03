package com.github.phakink;

import com.github.phakink.panel.ModeSelectionPanel;
import java.awt.*;

public class Core {

	private static UserCache cache;

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			try {
				cache = new UserCache();

				ModeSelectionPanel modeSelectionPanel = new ModeSelectionPanel();
				modeSelectionPanel.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public static UserCache getCache() {
		return cache;
	}
}
