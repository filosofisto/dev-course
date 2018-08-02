package com.javabasico;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Passe o nome do diretorio para criar");
			System.exit(-1);
		}
		
		Path newdir = FileSystems.getDefault().getPath(args[0]);
		Set<PosixFilePermission> perms = 
				PosixFilePermissions.fromString("rw-rw-r--");
		FileAttribute<Set<PosixFilePermission>> attrs = 
				PosixFilePermissions.asFileAttribute(perms);
		
		try {
			Files.createDirectory(newdir, attrs);
			System.out.println("Diretorio criado com sucesso");
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
