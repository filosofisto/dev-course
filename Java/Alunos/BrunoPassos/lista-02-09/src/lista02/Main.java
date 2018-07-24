package lista02;

import java.util.Scanner;

public class Main {

	/*
	 * 9. Elaborar um programa que lê 2 números e imprime a mensagem:
	 * "São múltiplos" ou "Não são múltiplos”.
	 */

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Informe dois valores: ");
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		
		if(a % b == 0) {
			System.out.println(" São multiplos");
		}else if(b % a == 0){
			System.out.println("São multiplos");
		}else {
			System.out.println("Nao sao multiplos");
		}
		
		

	}

}
