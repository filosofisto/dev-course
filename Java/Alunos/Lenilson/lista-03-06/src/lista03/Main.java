package lista03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Identificação de Número Primo\n");
		
		//Leitura do Console
		System.out.print("Informe um número: ");
		int n1 = ler.nextInt();
		
		//Verificacao
		if(n1 > 0) {
			for (int i = n1 - 1; i > 1; i--) {
				if (n1 % i == 0) {
					System.out.printf("\nO numero %d não é PRIMO!!!\n", n1);
					System.exit(0);
				}
			}
			System.out.printf("\nO número %d é PRIMO!!!", n1);
		
		} else {
			System.out.printf("\nNúmero inválido.", n1);
		}
	}

}
