package com.github.phakink.panel.hard;

import com.github.phakink.models.Gamemode;
import com.github.phakink.models.GuessingPanel;
import com.github.phakink.registry.FlagRegister;

import javax.swing.*;

public class EswatiniFlagPanel extends GuessingPanel {

	public EswatiniFlagPanel() {
		super(Gamemode.HARD ,"South Sudan", "Morocco", "Libya", "Eswatini");

		choiceOneEvent(e -> onClick(false));
		choiceTwoEvent(e -> onClick(false));
		choiceThreeEvent(e -> onClick(false));
		choiceFourEvent(e -> onClick(true));

		setLoggerInfo("Eswatini");
	}

	@Override
	protected String imagePath() {
		return "/Images/FlagHard/Eswatini.png";
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
		GuessingPanel randomPanel = flagRegister.randomQuiz(Gamemode.HARD);

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
