package com.github.phakink.utils;

import java.util.ArrayList;
import java.util.List;

public final class Common {

	private Common() {}

	public static <T> List<T> toList(final Iterable<T> it) {
		final List<T> list = new ArrayList<>();

		if (it != null)
			it.forEach(el -> {
				if (el != null)
					list.add(el);
			});

		return list;
	}

	public static void checkNotNull(Object check , String message) {
		if (check == null)
			throw new NullPointerException(message);
	}
}
