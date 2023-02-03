package com.github.phakink.panel.medium;

import com.github.phakink.models.Gamemode;
import com.github.phakink.models.GuessingPanel;
import com.github.phakink.registry.FlagEasyRegister;
import com.github.phakink.registry.FlagMediumRegister;

import javax.swing.*;

public class AfghanistanFlagPanel extends GuessingPanel {

	public AfghanistanFlagPanel() {
		super(Gamemode.MEDIUM ,"Malaysia", "Montenegro", "German", "Afghanistan");

		choiceOneEvent(e -> onClick(false));
		choiceTwoEvent(e -> onClick(false));
		choiceThreeEvent(e -> onClick(false));
		choiceFourEvent(e -> onClick(true));
	}

	@Override
	protected String imagePath() {
		return "/Images/FlagMedium/Afghanistan.png";
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
