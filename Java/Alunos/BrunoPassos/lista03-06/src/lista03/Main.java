package lista03;

import java.util.Scanner;

public class Main {
	// 6. Construa um programa para ler do console um n�mero e informar se o mesmo �
	// �Primo�.
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Informe um numero para verificar se � primo");
		int numero = scan.nextInt();
		
		if(numero % 2 ==0) {
			System.out.println(numero + " n�o � primo");
		}else if(numero % 2 ==1) {
			System.out.println(numero + " � primo");
		}
	}

}
