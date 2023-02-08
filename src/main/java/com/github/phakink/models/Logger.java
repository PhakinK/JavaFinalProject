package com.github.phakink.models;

import com.github.phakink.utils.Common;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Logger {

	private static final Logger instance = new Logger();

	private final List<String> lores = new ArrayList<>();

	public void addLore(String lore) {
		lores.add(lore);
	}

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


	public static Logger getInstance() {
		return instance;
	}
}
