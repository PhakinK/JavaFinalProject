package com.github.phakink.registry;

import com.github.phakink.models.GuessingPanel;
import com.github.phakink.panel.JapanFlagPanel;
import com.github.phakink.panel.SouthKoreaFlagPanel;
import com.github.phakink.panel.ThailandFlagPanel;
import com.github.phakink.utils.RandomUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FlagEasyRegister {

	private static final FlagEasyRegister instance = new FlagEasyRegister();

	private final Map<GuessingPanel , Boolean> map = new HashMap<>();

	private FlagEasyRegister() {

		map.put(new ThailandFlagPanel() , false); // If true, randomQuiz won't add that panel to list
		map.put(new JapanFlagPanel() , false);
		map.put(new SouthKoreaFlagPanel() , false);
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


	public static FlagEasyRegister getInstance() {
		return instance;
	}
}
