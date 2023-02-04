package com.github.phakink.panel.medium;

import com.github.phakink.models.Gamemode;
import com.github.phakink.models.GuessingPanel;
import com.github.phakink.registry.FlagRegister;

import javax.swing.*;

public class LuxembourgFlagPanel extends GuessingPanel {

	public LuxembourgFlagPanel() {
		super(Gamemode.MEDIUM ,"Colombia", "Russia", "Luxembourg", "Netherlands");

		choiceOneEvent(e -> onClick(false));
		choiceTwoEvent(e -> onClick(false));
		choiceThreeEvent(e -> onClick(true));
		choiceFourEvent(e -> onClick(false));
	}

	@Override
	protected String imagePath() {
		return "/Images/FlagMedium/Luxembourg.png";
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
