package com.github.phakink.registry;

import com.github.phakink.models.FlagData;
import com.github.phakink.models.Gamemode;
import com.github.phakink.models.GuessingPanel;
import com.github.phakink.panel.easy.*;
import com.github.phakink.panel.hard.*;
import com.github.phakink.panel.medium.*;
import com.github.phakink.utils.RandomUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FlagRegister {

	private static final FlagRegister instance = new FlagRegister();

	private final Map<FlagData , Boolean> map = new HashMap<>();

	private FlagRegister() {

		map.put(new FlagData(new EnglandFlagPanel() , Gamemode.EASY), false); // If true, randomQuiz won't add that panel to list
		map.put(new FlagData(new GermanFlagPanel() ,Gamemode.EASY), false);
		map.put(new FlagData(new ThailandFlagPanel() ,Gamemode.EASY), false);
		map.put(new FlagData(new JapanFlagPanel() ,Gamemode.EASY), false);
		map.put(new FlagData(new SouthKoreaFlagPanel() ,Gamemode.EASY), false);
		map.put(new FlagData(new ChinaFlagPanel() ,Gamemode.EASY), false);
		map.put(new FlagData(new USAFlagPanel() ,Gamemode.EASY), false);
		map.put(new FlagData(new NetherlandsFlagPanel() ,Gamemode.EASY), false);
		map.put(new FlagData(new NorwayFlagPanel() ,Gamemode.EASY), false);
		map.put(new FlagData(new SpainFlagPanel() ,Gamemode.EASY), false);
		map.put(new FlagData(new SwedenFlagPanel() ,Gamemode.EASY), false);

		map.put(new FlagData(new AfghanistanFlagPanel() , Gamemode.MEDIUM), false);
		map.put(new FlagData(new CroatiaFlagPanel() ,Gamemode.MEDIUM), false);
		map.put(new FlagData(new EcuadorFlagPanel() ,Gamemode.MEDIUM), false);
		map.put(new FlagData(new EgyptFlagPanel() ,Gamemode.MEDIUM), false);
		map.put(new FlagData(new LuxembourgFlagPanel() ,Gamemode.MEDIUM), false);
		map.put(new FlagData(new MaltaFlagPanel() ,Gamemode.MEDIUM), false);
		map.put(new FlagData(new PakistanFlagPanel() ,Gamemode.MEDIUM), false);
		map.put(new FlagData(new ParaguayFlagPanel() ,Gamemode.MEDIUM), false);
		map.put(new FlagData(new SerbiaFlagPanel() ,Gamemode.MEDIUM), false);
		map.put(new FlagData(new SomaliaFlagPanel() ,Gamemode.MEDIUM), false);
		map.put(new FlagData(new UruguayFlagPanel() ,Gamemode.MEDIUM), false);

		map.put(new FlagData(new AngolaFlagPanel() , Gamemode.HARD) , false);
		map.put(new FlagData(new BarbadosFlagPanel(), Gamemode.HARD) , false);
		map.put(new FlagData(new BotswanaFlagPanel(), Gamemode.HARD) , false);
		map.put(new FlagData(new EswatiniFlagPanel(), Gamemode.HARD) , false);
		map.put(new FlagData(new GeorgiaFlagPanel(), Gamemode.HARD) , false);
		map.put(new FlagData(new GrenadaFlagPanel() , Gamemode.HARD) , false);
		map.put(new FlagData(new KiribatiFlagPanel() , Gamemode.HARD) , false);
		map.put(new FlagData(new LesothoFlagPanel() , Gamemode.HARD) , false);
		map.put(new FlagData(new MadagascarFlagPanel() , Gamemode.HARD) , false);
		map.put(new FlagData(new MauritiusFlagPanel() , Gamemode.HARD) , false);
		map.put(new FlagData(new MongoliaFlagPanel() , Gamemode.HARD) , false);
	}


	public GuessingPanel randomQuiz(Gamemode gamemode) {

		List<GuessingPanel> list = new ArrayList<>();

		for (Map.Entry<FlagData , Boolean> entry : map.entrySet())
			if (entry.getKey().getGamemode() == gamemode && !entry.getValue())
				list.add(entry.getKey().getGamePanel());

		if (list.isEmpty())
			return null;

		return RandomUtil.nextItem(list);
	}

	public void show(GuessingPanel panel) {
		panel.setVisible(true);
	}

	public void setState(GuessingPanel panel , boolean state) {
		for (Map.Entry<FlagData , Boolean> entry : map.entrySet())
			if (entry.getKey().getGamePanel().equals(panel))
				map.replace(entry.getKey() , state);
	}

	public void clearState() {

		for (Map.Entry<FlagData , Boolean> entry : map.entrySet())
			map.replace(entry.getKey() , false);

	}


	public static FlagRegister getInstance() {
		return instance;
	}
}
