package com.javabasico;

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
		
		final Path path = FileSystems.getDefault().getPath(args[0]);

		DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
			@Override
			public boolean accept(Path entry) throws IOException {
				return Files.isDirectory(entry) && !Files.isHidden(entry) && !Files.newDirectoryStream(entry).iterator().hasNext();
			}
		};

		try(DirectoryStream<Path> ds = Files.newDirectoryStream(path, filter)) {
			for (Path file: ds) {
				System.out.println(file.toAbsolutePath());
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
