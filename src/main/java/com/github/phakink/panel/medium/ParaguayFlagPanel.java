package com.github.phakink.panel.medium;

import com.github.phakink.models.Gamemode;
import com.github.phakink.models.GuessingPanel;
import com.github.phakink.registry.FlagRegister;

import javax.swing.*;

public class ParaguayFlagPanel extends GuessingPanel {

	public ParaguayFlagPanel() {
		super(Gamemode.MEDIUM ,"Ecuador", "Paraguay", "Netherlands", "Russia");

		choiceOneEvent(e -> onClick(false));
		choiceTwoEvent(e -> onClick(true));
		choiceThreeEvent(e -> onClick(false));
		choiceFourEvent(e -> onClick(false));

		setLoggerInfo("Paraguay");
	}

	@Override
	protected String imagePath() {
		return "/Images/FlagMedium/Paraguay.png";
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
		FlagRegister flagRegister = FlagRegister.getInstance();
		GuessingPanel randomPanel = flagRegister.randomQuiz(Gamemode.MEDIUM);

		if (randomPanel == null) {
			EndOfGameFrame endOfGameFrame = new EndOfGameFrame();
			endOfGameFrame.setLocation(this.getX() , this.getY());
			this.dispose();
			return endOfGameFrame;
		}

		this.dispose();

		return randomPanel;
	}
}
