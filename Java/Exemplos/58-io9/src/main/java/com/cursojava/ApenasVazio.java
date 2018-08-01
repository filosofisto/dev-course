package com.cursojava;

import java.io.File;
import java.io.FileFilter;

public class ApenasVazio implements FileFilter {

    @Override
    public boolean accept(File file) {
        return file.isFile() && file.length() == 0;
    }
}
