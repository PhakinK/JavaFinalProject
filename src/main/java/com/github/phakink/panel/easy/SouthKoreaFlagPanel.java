package com.github.phakink.panel.easy;

import com.github.phakink.Core;
import com.github.phakink.models.Gamemode;
import com.github.phakink.models.GuessingPanel;
import com.github.phakink.registry.FlagRegister;

import javax.swing.*;

public class SouthKoreaFlagPanel extends GuessingPanel {

	public SouthKoreaFlagPanel() {
		super(Gamemode.EASY ,"Norway" , "Senegal" , "Ecuador" , "South Korea");

		setTitle("Country (Easy) | Score: " + Core.getCache().getPoint());

		choiceOneEvent(e -> onClick(false));
		choiceTwoEvent(e -> onClick(false));
		choiceThreeEvent(e -> onClick(false));
		choiceFourEvent(e -> onClick(true));
	}

	@Override
	protected String imagePath() {
		return "/Images/FlagEasy/South Korea.png";
	}

	@Override
	public JFrame nextChoice() {
		FlagRegister flagRegistry = FlagRegister.getInstance();
		GuessingPanel randomPanel = flagRegistry.randomQuiz(Gamemode.EASY);

		if (randomPanel == null) {
			EndOfGameFrame endOfGameFrame = new EndOfGameFrame();
			endOfGameFrame.setLocation(this.getX() , this.getY());
			this.dispose();
			return endOfGameFrame;
		}

		this.dispose();

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
