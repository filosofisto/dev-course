package com.javabasico;

import static java.lang.System.out;
import static java.lang.System.currentTimeMillis;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Path txtPath = Paths.get("/home/eduardo/Downloads", "ArquivoTexto.txt");
		Charset charset = Charset.forName("ISO-8859-1");
		
		try {
			long t1 = currentTimeMillis();
			List<String> lines = Files.readAllLines(txtPath, charset);
			long t2 = currentTimeMillis();
			
			out.printf("Linhas lidas: %d\n", lines.size());
			out.printf("Tempo de processamento: %d (ms)\n", (t2-t1));
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
