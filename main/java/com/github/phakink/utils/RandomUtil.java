package com.github.phakink.utils;

import java.util.*;
import java.util.function.Predicate;

public final class RandomUtil {

	private RandomUtil() {}

	private static final Random random = new Random();


	public static boolean chance(final int percent) {
		return random.nextDouble() * 100D < percent;
	}

	public static int nextInt(int bound) {
		return random.nextInt(bound);
	}

	public static <T> T nextItem(final Iterable<T> items) {
		return nextItem(items, null);
	}

	public static<T> T nextItem(final Iterable<T> items, final Predicate<T> condition) {

		final List<T> list = items instanceof List ? new ArrayList<>((List<T>) items) : Common.toList(items);

		if (condition != null)
			list.removeIf(condition);

		return list.get(nextInt(list.size()));
	}

}
