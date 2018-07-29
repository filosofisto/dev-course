package com.javabasico;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Path path = Paths.get("/home/eduardo/temp", "wiki.txt");
		Charset charset = Charset.forName("UTF-8");
		
		List<String> lines = new ArrayList<>();
		lines.add("\n");
		lines.add("Rome Masters - 5 titles in 6 years");
		lines.add("Monte Carlo Masters - 7 consecutive titles (2005-2011)");
		lines.add("Australian Open - Winner 2009");
		lines.add("Roland Garros - Winner 2005-2008, 2010, 2011");
		lines.add("Wimbledon - Winner 2008, 2010");
		lines.add("US Open - Winner 2010");
		
		try {
			Files.write(path, lines, charset, StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
