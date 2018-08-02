package com.javabasico;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Passe o nome do diretorio para listar os arquivos");
			System.exit(-1);
		}
		
		Path path = FileSystems.getDefault().getPath(args[0]);
		
		try(DirectoryStream<Path> ds = Files.newDirectoryStream(path)) {
			for (Path file: ds) {
				System.out.println(file.toAbsolutePath());
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
