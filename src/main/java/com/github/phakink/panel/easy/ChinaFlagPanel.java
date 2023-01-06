package com.github.phakink.panel.easy;

import com.github.phakink.models.GuessingPanel;
import com.github.phakink.registry.FlagEasyRegister;

import javax.swing.*;

public class ChinaFlagPanel extends GuessingPanel {

	public ChinaFlagPanel() {
		super("Vietnam", "China", "Taiwan", "Indonesia");

		choiceOneEvent(e -> onClick(false));
		choiceTwoEvent(e -> onClick(true));
		choiceThreeEvent(e -> onClick(false));
		choiceFourEvent(e -> onClick(false));
	}

	@Override
	protected String imagePath() {
		return "/Images/FlagEasy/China.png";
	}

	@Override
	public int increment() {
		return 1;
	}

	@Override
	public int decreasement() {
		return 1;
	}

	@Override
	public JFrame nextChoice() {
		FlagEasyRegister flagRegistry = FlagEasyRegister.getInstance();
		GuessingPanel randomPanel = flagRegistry.randomQuiz();

		if (flagRegistry.randomQuiz() == null) {
			EndOfGameFrame endOfGameFrame = new EndOfGameFrame();
			endOfGameFrame.setLocation(this.getX() , this.getY());
			return endOfGameFrame;
		}

		return randomPanel;
	}
}
