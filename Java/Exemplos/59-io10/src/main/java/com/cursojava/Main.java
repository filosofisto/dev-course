package com.cursojava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Main {

	public static void main(String[] args) {
		try {
			File fin = new File("/home/eduardo/temp/Treinamento Java-v2.doc");
			System.out.printf("Tamanho original: %d\n", fin.length());
			File fout = new File("/home/eduardo/temp/Treinamento Java-v2.doc.gzip");
			compactarGZip(
					new FileInputStream(fin),
					new FileOutputStream(fout)
			);
			System.out.printf("Tamanho compactado: %d\n", fout.length());
			System.out.printf("Percentual Ganho %.0f %%", ((float)fout.length())/fin.length()*100f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void compactarGZip(InputStream in, OutputStream out) 
			throws IOException {
		byte[] buf = new byte[512];
		int off = 0;
		int len = buf.length;
		
		GZIPOutputStream gzip = 
				new GZIPOutputStream(out);
		while ((len = in.read(buf, off, len)) != -1) {
			gzip.write(buf, off, len);
		}
		
		gzip.close();
	}
	
	public static void descompactarGZip(InputStream in, OutputStream out) 
			throws IOException {
		byte[] buf = new byte[512];
		int off = 0;
		int len = buf.length;
		
		GZIPInputStream gzip = new GZIPInputStream(in);
		
		while ((len = gzip.read(buf, off, len)) != -1) {
			out.write(buf, off, len);
		}
		
		out.close();
		gzip.close();
	}
}
