package com.javabasico;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Passe o nome do diretorio para listar os arquivos e o pattern para filtro (Ex: *.{png,jpg,bmp})");
			System.exit(-1);
		}
		
		Path path = FileSystems.getDefault().getPath(args[0]);
		
		try(DirectoryStream<Path> ds = Files.newDirectoryStream(path, args[1])) {
			for (Path file: ds) {
				System.out.println(file.getFileName());
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
