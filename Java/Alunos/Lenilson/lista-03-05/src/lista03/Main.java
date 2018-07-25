package lista03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int result = 0;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Calculo da soma de valores no intervalo [a,b]\n\t onde: b > a\n");
		
		//Leitura do Console
		System.out.print("Informe o numero inicial: ");
		int in = ler.nextInt();
		System.out.print("Informe o numero final: ");
		int fim = ler.nextInt();
		
		//Soma de todos os valores entre a faixa [inicial - final]
		for (int i = in; i <= fim; i++) {
			result += i; 
		}
		
		//Resultado
		System.out.printf("\nResultado da soma de todos os valores entre %d e %d: %d", in, fim, result);

	}

}
