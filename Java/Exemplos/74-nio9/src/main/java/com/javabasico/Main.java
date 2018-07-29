package com.javabasico;

import static java.lang.System.out;
import static java.lang.System.currentTimeMillis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		Path picturePath = Paths.get("/home/eduardo/Pictures", "mcdonalds.png");

		try {
			long t1 = currentTimeMillis();
			byte[] bytes = Files.readAllBytes(picturePath);
			long t2 = currentTimeMillis();
			
			out.printf("Bytes lidos: %d\n", bytes.length);
			out.printf("Tempo de processamento: %d (ms)\n", (t2-t1));
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
