package lista02;

import java.util.Scanner;

public class Main {

	/*
	 * 9. Elaborar um programa que l� 2 n�meros e imprime a mensagem:
	 * "S�o m�ltiplos" ou "N�o s�o m�ltiplos�.
	 */

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Informe dois valores: ");
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		
		if(a % b == 0) {
			System.out.println(" S�o multiplos");
		}else if(b % a == 0){
			System.out.println("S�o multiplos");
		}else {
			System.out.println("Nao sao multiplos");
		}
		
		

	}

}
