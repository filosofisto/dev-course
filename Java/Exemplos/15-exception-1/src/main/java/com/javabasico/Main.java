package com.javabasico;

import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		/*int x = 3 / 0;
		System.out.printf("x = %d", x);*/
		
		try {
			int x = 3 / 0;
			System.out.printf("x = %d\n", x);
			
			int[] array = new int[10];
			array[5] = 1;
		} catch (ArithmeticException e) {
			System.err.println("Nao sei dividir por ZERO, vc sabe?");
		} catch (Exception e) {
			System.err.println("Erro de array: " + e.getMessage());
		} finally {
			System.out.println("Bye;)");
		}
		
		/*int[] array = new int[10];
		
		try {
			System.out.println(array[50]);
		} catch (RuntimeException e) {
			System.out.println("vixi");
		}*/
		
		/*try {
			connection.open();
			connection.startTransaction();
			connection.insert(...);
			connection.insert(...);
			connection.update(...);
			if (????) {
				conneciob.rollback();
				return;
			}
			connection.delete(...);
			connection.commitTransaction();
		} catch (Exception e) {
			connection.rollback();
		} finally {
			connection.close();
		}*/
	}
}
