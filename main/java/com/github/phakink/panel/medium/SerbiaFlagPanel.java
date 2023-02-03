package com.github.phakink.panel.medium;

import com.github.phakink.models.Gamemode;
import com.github.phakink.models.GuessingPanel;
import com.github.phakink.registry.FlagMediumRegister;

import javax.swing.*;

public class SerbiaFlagPanel extends GuessingPanel {

	public SerbiaFlagPanel() {
		super(Gamemode.MEDIUM ,"Cuba", "Croatia", "Serbia", "Panama");

		choiceOneEvent(e -> onClick(false));
		choiceTwoEvent(e -> onClick(false));
		choiceThreeEvent(e -> onClick(true));
		choiceFourEvent(e -> onClick(false));
	}

	@Override
	protected String imagePath() {
		return "/Images/FlagMedium/Serbia.png";
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
		FlagMediumRegister flagRegistry = FlagMediumRegister.getInstance();
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
