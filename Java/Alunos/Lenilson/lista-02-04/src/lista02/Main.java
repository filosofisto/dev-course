package lista02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		//Leitura do Console
		System.out.println("Informe a idade em anos, meses, e dias (pressione enter para cada valor informado): ");
		int anos = ler.nextInt();
		int meses = ler.nextInt();
		int dias = ler.nextInt();
		
		//Determinar a idade em dias
		System.out.printf("\nIdade em dias: %d", anos * 365 + meses * 30 + dias);
	}

}
