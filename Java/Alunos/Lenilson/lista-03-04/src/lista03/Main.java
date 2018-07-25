package lista03;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		//Declaracao das variaveis
		Random rnd = new Random();
		long result = 1;
		
		System.out.println("Calculo de Fatorial entre numeros de 1 e 20\n");
		
		//Sorteio de um numero entre 1 e 20
		int n1 = rnd.nextInt(20) + 1;
		System.out.printf("Numero sorteado: %d", n1);
		
		long t1 = System.currentTimeMillis();
		
		//Calculo do Fatorial usando for
		for(int i = n1; i > 1; i--) {
			result *= i;
		}
		
		long t2 = System.currentTimeMillis();
		System.out.println("Tempos de processamento: " + (t2-t1) + " ms");
		
		//Resultado
		System.out.printf("\nFatorial de %d: %d", n1, result);
	}

}
