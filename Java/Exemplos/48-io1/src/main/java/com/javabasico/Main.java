package com.javabasico;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		String dirName =
			ajustarSepadador(
				"\\home\\eduardo\\temp"
			);
		File dir = new File(dirName);
		
		for (File f: dir.listFiles()) {
			if (f.isDirectory()) {
				System.out.println(f.getAbsolutePath());
			} else {
				System.out.printf("%s - %d bytes\n",
						f.getAbsolutePath(),
						f.length());
			}
		}
	}
	
	private static String ajustarSepadador(
			String texto) {
		return texto.replace(
				"\\", File.separator);
	}

}
