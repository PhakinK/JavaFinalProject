package com.github.phakink.registry;

import com.github.phakink.models.GuessingPanel;
import com.github.phakink.utils.RandomUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FlagMediumRegister {

	private static final FlagMediumRegister instance = new FlagMediumRegister();

	private final Map<GuessingPanel, Boolean> map = new HashMap<>();

	private FlagMediumRegister() {


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
