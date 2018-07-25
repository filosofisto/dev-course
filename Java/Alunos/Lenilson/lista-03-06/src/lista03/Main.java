package lista03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Identifica��o de N�mero Primo\n");
		
		//Leitura do Console
		System.out.print("Informe um n�mero: ");
		int n1 = ler.nextInt();
		
		//Verificacao
		if(n1 > 0) {
			for (int i = n1 - 1; i > 1; i--) {
				if (n1 % i == 0) {
					System.out.printf("\nO numero %d n�o � PRIMO!!!\n", n1);
					System.exit(0);
				}
			}
			System.out.printf("\nO n�mero %d � PRIMO!!!", n1);
		
		} else {
			System.out.printf("\nN�mero inv�lido.", n1);
		}
	}

}
