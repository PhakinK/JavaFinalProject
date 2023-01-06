package com.github.phakink.panel.easy;

import com.github.phakink.Core;
import com.github.phakink.models.GuessingPanel;
import com.github.phakink.registry.FlagEasyRegister;

import javax.swing.*;

public class NorwayFlagPanel extends GuessingPanel {

	public NorwayFlagPanel() {
		super("Romania", "Venezuela", "Iceland", "Norway");

		choiceOneEvent(e -> onClick(false));
		choiceTwoEvent(e -> onClick(false));
		choiceThreeEvent(e -> onClick(false));
		choiceFourEvent(e -> onClick(true));
	}

	@Override
	protected String imagePath() {
		return "/Images/FlagEasy/Norway.png";
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
