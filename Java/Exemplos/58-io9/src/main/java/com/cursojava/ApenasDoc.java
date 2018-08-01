package com.cursojava;

import java.io.File;
import java.io.FileFilter;

public class ApenasDoc implements FileFilter {

	@Override
	public boolean accept(File file) {
		return file.isFile()
			&& (file.getName().endsWith(".doc") || file.getName().endsWith(".docx"));
	}
}
