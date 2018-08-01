package com.javabasico;

import static java.lang.System.out;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//Console c = System.console();
		
		//out.println("Entre com o nome do arquivo desejado: ");
		String toFind = args[0]; //c.readLine();
		String dirName = System.getProperty("user.dir");
		File dir = new File(dirName);
		
		List<String> arquivos = new ArrayList<String>();
		
		findFile(dir, toFind, arquivos);
		for (String fileName: arquivos) {
			System.out.printf("Achei em %s\n", fileName);
			//System.out.printf("Tamanho: %d bytes", file.length());
		}
	}
	
	static void findFile(
			File dir, 
			String toFind, 
			List<String> arquivos) {
		for (File f: dir.listFiles()) {
			if (f.isFile()) {
				if (f.getName().equals(toFind)) {
					arquivos.add(f.getAbsolutePath());
					break;
				}
			}
		}
		
		for (File f: dir.listFiles()) {
			if (f.isDirectory()) {
				findFile(f, toFind, arquivos);
			}
		}
	}
}
