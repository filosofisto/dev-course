package lista03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int result = 1;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Calculo de Potencia\n");
		
		//Leitura do Console
		System.out.print("Informe o numero X: ");
		int x = ler.nextInt();
		System.out.print("Informe o numero Y: ");
		int y = ler.nextInt();
		
		//Potencia usando for
		for (int i = 1; i <= y; i++) {
			result *= x; 
		}
		
		//Resultado
		System.out.printf("\nResultado de %d elevado a %d: %d", x, y, result);
	}
}
