package com.github.phakink.panel.easy;

import com.github.phakink.models.Gamemode;
import com.github.phakink.models.GuessingPanel;
import com.github.phakink.registry.FlagEasyRegister;

import javax.swing.*;

public class EnglandFlagPanel extends GuessingPanel {

	public EnglandFlagPanel() {
		super(Gamemode.EASY ,"England", "Georgia", "Serbia", "Norway");

		choiceOneEvent(e -> onClick(true));
		choiceTwoEvent(e -> onClick(false));
		choiceThreeEvent(e -> onClick(false));
		choiceFourEvent(e -> onClick(false));
	}

	@Override
	protected String imagePath() {
		return "/Images/FlagEasy/England.png";
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
			this.dispose();
			return endOfGameFrame;
		}

		this.dispose();

		return randomPanel;
	}
}
