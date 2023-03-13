package com.github.phakink.models;

import com.github.phakink.utils.Common;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a log writing for tracking your accurate
 */
public final class Logger {

	/**
	 * Create singleton for this class.
	 */
	private static final Logger instance = new Logger();

	/**
	 * The list that hold log text data.
	 */
	private final List<String> lores = new ArrayList<>();

	private Logger() {}

	public void addLore(String lore) {
		lores.add(lore);
	}

	/**
	 * Write a log text to specific path
	 *
	 * @param path
	 * @throws IOException
	 */
	public void writeData(String path) throws IOException {

		FileWriter writer = new FileWriter(path , true);

		writer.write("-----------------------[ " + Common.getFormattedDate() + " ]----------------------\n");

		lores.forEach(lines -> {
			try {
				writer.append(lines).append("\n");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});

		writer.write("--------------------------------------------------------------------\n");

		writer.close();

		this.lores.clear();
	}


	/**
	 * Get instance for this class
	 *
	 * @return
	 */
	public static Logger getInstance() {
		return instance;
	}

}
