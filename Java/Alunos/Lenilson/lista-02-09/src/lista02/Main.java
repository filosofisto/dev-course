package lista02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		//Leitura do Console
		System.out.println("Informe o numero 1: ");
		int n1 = ler.nextInt();
		System.out.println("Informe o numero 2: ");
		int n2 = ler.nextInt();
		
		//Determinacao de multiplos
		if (n1 % n2 == 0) {
			System.out.println("Sao multiplos.");
		} else if (n2 % n1 == 0) {
			System.out.println("Sao multiplos.");
		} else {
			System.out.println("Nao sao multiplos.");
		}
	}

}
