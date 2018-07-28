package com.javabasico;

import java.io.Console;
import java.io.File;
import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		Console c = System.console();
		
		out.println("Entre com o nome do arquivo desejado: ");
		String toFind = c.readLine();
		String dirName = System.getProperty("user.dir");
		File dir = new File(dirName);
		
		File file = findFile(dir, toFind);
		if (file != null) {
			System.out.printf("Achei em %s\n", file.getAbsolutePath());
			System.out.printf("Tamanho: %d bytes", file.length());
		} else {
			System.out.println("Arquivo nao encontrado :(");
		}
	}
	
	static File findFile(File dir, String toFind) {
		for (File f: dir.listFiles()) {
			if (f.isFile()) {
				if (f.getName().equals(toFind)) {
					return f;
				}
			}
		}
		
		for (File f: dir.listFiles()) {
			if (f.isDirectory()) {
				File ret = findFile(f, toFind);
				if (ret != null) {
					return ret;
				}
			}
		}
		
		return null;
	}
}
