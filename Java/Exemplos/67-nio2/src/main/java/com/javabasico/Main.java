package com.javabasico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		Path path = Paths.get("/home/eduardo/Private/dev-course/.gitignore");
		
		try {
			if (Files.isHidden(path)) {
				System.out.println(".gitignore eh hidden");
			} else {
				System.out.println(".gitignore nao eh hidden");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
