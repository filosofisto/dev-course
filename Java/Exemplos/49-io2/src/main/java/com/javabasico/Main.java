package com.javabasico;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		try {
			File dir = new File("/home/eduardo/temp/java/curso/cpb");

			if (!dir.exists()) {
				if (!dir.mkdirs()) {
					System.out.println("Nao criou a pasta");
				} else {
					System.out.println("Criou a pasta");
				}
			} else {
				System.out.println("Pasta ja existe");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
