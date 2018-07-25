package lista03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Calculo de Fatorial\n");
		
		//Leitura do Console
		System.out.print("Informe um numero natural positivo: ");
		int n = ler.nextInt();
		
		//Resultado
		System.out.printf("\nFatorial de %d: %d", n, Fatorial(n));

	}
	
	private static long Fatorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * Fatorial (n - 1);
		}
	}

}
