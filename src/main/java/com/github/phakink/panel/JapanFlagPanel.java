package com.github.phakink.panel;

import com.github.phakink.Core;
import com.github.phakink.models.GuessingPanel;
import com.github.phakink.registry.FlagEasyRegister;

import javax.swing.*;

public class JapanFlagPanel extends GuessingPanel {

	public JapanFlagPanel() {
		super("Vietnam" , "Japan" , "Bangladesh" , "Greenland");

		setTitle("Country (Easy) | Score: " + Core.getCache().getPoint());


		choiceOneEvent(e -> onClick(false));
		choiceTwoEvent(e -> onClick(true));
		choiceThreeEvent(e -> onClick(false));
		choiceFourEvent(e -> onClick(false));
	}

	@Override
	protected String imagePath() {
		return "/Images/Japan.png";
	}

	@Override
	public JFrame nextChoice() {
		FlagEasyRegister flagRegistry = FlagEasyRegister.getInstance();
		GuessingPanel randomPanel = flagRegistry.randomQuiz();

		if (flagRegistry.randomQuiz() == null)
			return END_OF_GAME;

		return randomPanel;
	}

	@Override
	public int increment() {
		return 1;
	}

	@Override
	public int decreasement() {
		return 1;
	}
}
