package com.github.phakink.utils;

import java.util.*;
import java.util.function.Predicate;

/**
 * Utility class for random numbers or item in array.
 */
public final class RandomUtil {

	private RandomUtil() {}

	/**
	 * private instance for @Random class
	 */
	private static final Random random = new Random();

	/**
	 * Return true if given percent was higher than generating number.
	 *
	 * @param percent percent from 0 - 100.
	 * @return
	 */
	public static boolean chance(final int percent) {
		return random.nextDouble() * 100D < percent;
	}

	/**
	 * Random a number within define bound.
	 *
	 * @param bound scope of random number.
	 * @return
	 */
	public static int nextInt(int bound) {
		return random.nextInt(bound);
	}

	public static <T> T nextItem(final Iterable<T> items) {
		return nextItem(items, null);
	}

	/**
	 *
	 * Random item within anything that implements {@link Iterable}
	 * {@link Predicate} is acceptable for determines condition.
	 *
	 * @param items
	 * @param condition
	 * @return
	 * @param <T>
	 */
	public static<T> T nextItem(final Iterable<T> items, final Predicate<T> condition) {

		final List<T> list = items instanceof List ? new ArrayList<>((List<T>) items) : Common.toList(items);

		if (condition != null)
			list.removeIf(condition);

		return list.get(nextInt(list.size()));
	}

}
