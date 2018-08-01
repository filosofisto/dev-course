package com.cursojava;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File dir = new File("/home/eduardo/temp");

		for (File f: dir.listFiles(new ApenasDoc())) {
			System.out.println(f);
		}

	}
}
