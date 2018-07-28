package com.javabasico;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		try {
			File dir = new File("c:/temp/pdf/xpto");
			
			if (!dir.mkdirs()) {
				System.out.println("Nao criou a pasta");
			} else {
				System.out.println("Criou a pasta");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
