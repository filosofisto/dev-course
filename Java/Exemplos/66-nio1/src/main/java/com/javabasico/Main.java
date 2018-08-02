package com.javabasico;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Necessario passar o nome do arquivo");
			System.exit(-1);
		}
		
		Path path = Paths.get(args[0]);
		Files.exists(path, new LinkOption[] {LinkOption.NOFOLLOW_LINKS});
		
		boolean isAccessible = Files.isRegularFile(path) && Files.isReadable(path)
				/*&& Files.isExecutable(path)*/ && Files.isWritable(path);
		
		if (isAccessible) {
			System.out.println("Arquivo acessivel");
		} else {
			System.out.println("Arquivo nao acessivel");
		}
	}
}
