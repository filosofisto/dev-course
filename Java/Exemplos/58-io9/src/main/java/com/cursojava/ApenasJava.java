package com.cursojava;

import java.io.File;
import java.io.FilenameFilter;

public class ApenasJava implements FilenameFilter {

	@Override
	public boolean accept(File parent, String name) {
		return name.endsWith(".jar");
	}

}
