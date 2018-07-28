package com.x25.logicajava;

import java.io.File;
import java.io.FileFilter;

public class ApenasDoc implements FileFilter {

	@Override
	public boolean accept(File file) {
		return file.getName().startsWith("doc")
				|| file.getName().startsWith("docx");
	}
}
