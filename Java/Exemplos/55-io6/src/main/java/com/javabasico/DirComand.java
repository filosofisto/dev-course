package com.javabasico;

import java.io.File;

public class DirComand {
	
	public void dir(StringBuilder builder, File file) {
		for (File f: file.listFiles()) {
			if (f.isFile()) {
				builder.append(f.getAbsolutePath() + "\n");
			}
		}
		
		//Lista diretorios recursivamente
		for (File f: file.listFiles()) {
			if (f.isDirectory()) {
				dir(builder, f);
			}
		}
	}

}
