package lista03;

import java.util.Scanner;

public class Main {

	/*
	 * 5. Elabore um programa que solicite que o usuário entre com dois números
	 * (inicial e final), e apresente o valor total da soma de todos os números do
	 * intervalo informado.
	 */

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o numero inicial: ");
		int inicio = scan.nextInt(); 
		System.out.println("Digite o numero final: ");
		int fim = scan.nextInt();
		
		int soma = 0;
		for(int i=inicio;i<fim;i++){
		   soma += i;
		}
		System.out.println(soma);
	}

}
