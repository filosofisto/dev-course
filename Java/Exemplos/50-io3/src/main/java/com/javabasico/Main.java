package com.javabasico;

import java.io.File;
import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		String dirName = 
				"/home/eduardo/temp";
		File root = new File(dirName);
		
		list(root);
	}
	
	static void list(File dir) {
		out.println(dir.getAbsolutePath());

		for (File f: dir.listFiles()) {
			if (f.isFile()) {
				out.printf("%s - %d\n", f.getAbsolutePath(), f.length());
			}
		}

		for (File f: dir.listFiles()) {
			if (f.isDirectory()) {
				list(f);
			}
		}


	}

}
