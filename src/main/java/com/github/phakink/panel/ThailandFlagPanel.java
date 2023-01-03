package com.github.phakink.panel;

import com.github.phakink.Core;
import com.github.phakink.models.GuessingPanel;
import com.github.phakink.registry.FlagEasyRegister;

import javax.swing.*;

public class ThailandFlagPanel extends GuessingPanel {

	public ThailandFlagPanel() {
		super("Thailand" , "Vietnam" , "Singapore" , "Indonesia");

		setTitle("Country (Easy) | Score: " + Core.getCache().getPoint());
		choiceOneEvent(e -> onClick(true));
		choiceTwoEvent(e -> onClick(false));
		choiceThreeEvent(e -> onClick(false));
		choiceFourEvent(e -> onClick(false));
	}

	@Override
	protected String imagePath() {
		return "/Images/Thailand.png";
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
			return END_OF_GAME;
		}

		return randomPanel;
	}
}
