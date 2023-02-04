package com.github.phakink.models;

import java.util.Objects;

public final class FlagData {

	private final GuessingPanel gamePanel;
	private final Gamemode gamemode;

	public FlagData(GuessingPanel gamePanel, Gamemode gamemode) {
		this.gamePanel = gamePanel;
		this.gamemode = gamemode;
	}

	public GuessingPanel getGamePanel() {
		return gamePanel;
	}

	public Gamemode getGamemode() {
		return gamemode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FlagData flagData = (FlagData) o;
		return Objects.equals(gamePanel, flagData.gamePanel) && gamemode == flagData.gamemode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gamePanel, gamemode);
	}

	@Override
	public String toString() {
		return "FlagData{" +
				"gamePanel=" + gamePanel +
				", gamemode=" + gamemode +
				'}';
	}
}
