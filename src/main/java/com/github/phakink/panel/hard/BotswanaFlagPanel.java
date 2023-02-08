package com.github.phakink.panel.hard;

import com.github.phakink.models.Gamemode;
import com.github.phakink.models.GuessingPanel;
import com.github.phakink.registry.FlagRegister;

import javax.swing.*;

public class BotswanaFlagPanel extends GuessingPanel {

	public BotswanaFlagPanel() {
		super(Gamemode.HARD ,"Niger", "Barbados", "Botswana", "Liberia");

		choiceOneEvent(e -> onClick(false));
		choiceTwoEvent(e -> onClick(false));
		choiceThreeEvent(e -> onClick(true));
		choiceFourEvent(e -> onClick(false));

		setLoggerInfo("Botswana");
	}

	@Override
	protected String imagePath() {
		return "/Images/FlagHard/Botswana.png";
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
