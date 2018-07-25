package lista03;

import java.util.Scanner;

public class Main {

	/*
	 * 3. Construa um programa que leia dois números inteiros, X e Y, e mostre o
	 * resultado de X elevado a potência Y. Utilize estruturas de repetição.
	 */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Informe dois valores inteiros: ");
		int x = scan.nextInt();
		int y = scan.nextInt();

		/*
		 * base = 2 expoente = 3
		 * 
		 * resultado = 2*2*2
		 * 
		 * 
		 * 
		 */
		int resultado = 1;
		do {
			resultado = resultado * x;
			y--;
		} while (y >= 1);

		System.out.println("RE WHILE " + resultado);

	}

}
