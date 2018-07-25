package lista03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Calculo de Fatorial\n");
		
		//Leitura do Console
		System.out.print("Informe um numero natural positivo: ");
		int n = ler.nextInt();
		
		long t1 = System.currentTimeMillis();
		//Resultado
		System.out.printf("\nFatorial de %d: %d", n, fatorial(n));
		long t2 = System.currentTimeMillis();
		System.out.println("Tempos de processamento: " + (t2-t1) + " ms");
	}
	
	private static long fatorial(int n) {
		if (n < 2) {
			return 1;
		} else {
			return n * fatorial (n - 1);
		}
	}

}
