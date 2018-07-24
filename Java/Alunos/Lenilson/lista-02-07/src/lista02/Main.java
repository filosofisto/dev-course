package lista02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner(System.in);
		
		//Leitura do Console
		System.out.print("Informe o custo de fabrica do veiculo: R$ ");
		float custo = ler.nextFloat();
		
		//Custo final do veiculo
		System.out.printf("\nCusto final: R$ %.2f", custo * 1.468);
	}

}
