package com.sqli.Labyrinth.Labyrinth;

import java.util.List;

public class StringPrinter implements Printer {

	public String print(List<String> paths) {
		return String.join(";", paths);
	}

}
