package com.github.phakink.panel;

import com.github.phakink.Core;
import com.github.phakink.models.GuessingPanel;
import com.github.phakink.registry.FlagEasyRegister;

import javax.swing.*;

public class JapanFlagPanel extends GuessingPanel {

	public JapanFlagPanel() {
		super("Vietnam" , "Japan" , "Bangladesh" , "Greenland");

		setTitle("Country (Easy) | Score: " + Core.getCache().getPoint());

		choiceTwoEvent(e -> correctAnswer());
	}

	@Override
	protected String imagePath() {
		return "/Images/Japan.png";
	}

	@Override
	public JFrame nextChoice() {
		return FlagEasyRegister.getInstance().randomQuiz();
	}

	@Override
	public void correctAnswer() {
		super.correctAnswer();

		Core.getCache().increasePoint(1);
	}

	@Override
	public int increment() {
		return 1;
	}
}
