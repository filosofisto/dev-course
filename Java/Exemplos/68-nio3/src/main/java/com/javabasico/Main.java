package com.javabasico;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		
		for (Path name: dirs) {
			System.out.println(name);
		}
	}
}
