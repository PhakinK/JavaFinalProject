package com.github.phakink.registry;

import com.github.phakink.models.GuessingPanel;
import com.github.phakink.panel.easy.EnglandFlagPanel;
import com.github.phakink.panel.medium.*;
import com.github.phakink.utils.RandomUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FlagMediumRegister {

	private static final FlagMediumRegister instance = new FlagMediumRegister();

	private final Map<GuessingPanel, Boolean> map = new HashMap<>();

	private FlagMediumRegister() {

		map.put(new AfghanistanFlagPanel(), false);
		map.put(new CroatiaFlagPanel(), false);
		map.put(new EcuadorFlagPanel(), false);
		map.put(new EgyptFlagPanel(), false);
		map.put(new LuxembourgFlagPanel(), false);
		map.put(new MaltaFlagPanel(), false);
		map.put(new PakistanFlagPanel(), false);
		map.put(new ParaguayFlagPanel(), false);
		map.put(new SerbiaFlagPanel(), false);
		map.put(new SomaliaFlagPanel(), false);
		map.put(new UruguayFlagPanel(), false);
	}

	public GuessingPanel randomQuiz() {

		List<GuessingPanel> list = new ArrayList<>();

		for (Map.Entry<GuessingPanel , Boolean> entry : map.entrySet())
			if (!entry.getValue())
				list.add(entry.getKey());

		if (list.isEmpty())
			return null;

		return RandomUtil.nextItem(list);
	}

	public void show(GuessingPanel panel) {
		panel.setVisible(true);
	}

	public void setState(GuessingPanel panel , boolean state) {
		map.replace(panel , state);
	}

	public void clearState() {

		for (Map.Entry<GuessingPanel , Boolean> entry : map.entrySet())
			map.replace(entry.getKey() , false);

	}


	public static FlagMediumRegister getInstance() {
		return instance;
	}

}
