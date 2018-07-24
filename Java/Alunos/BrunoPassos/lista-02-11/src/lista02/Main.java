package lista02;

import java.util.Scanner;

public class Main {

	/*
	 * 11. Um usuário deseja um algoritmo onde possa escolher que tipo de média
	 * deseja calcular a partir de 3 notas. Faça um programa que leia a partir do
	 * console as notas, a opção escolhida pelo usuário e calcule o resultado.
	 * Opções: (1) aritmética, (2) ponderada [valores da ponderação: 3,3,4] e (3)
	 * harmônica.
	 */

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Informe o valor de 3 notas");
		float n1 = scan.nextFloat();
		float n2 = scan.nextFloat();
		float n3 = scan.nextFloat();
		
		System.out.println("Informe qual opção deseja para ser realizado o calculo\n"
				+"Opcao 1 > Media Aritmetica\n"
				+ "Opcao 2 > Media Ponderada\n"
				+ "Opcao 3 > Media Harmonica\n");
		int opcao = scan.nextInt();
		
		if(opcao < 1 || opcao > 3) {
			System.out.println("Opcao invalida");
		}else if(opcao == 1) {
			System.out.println("A media aritmetica é: " + mediaAritmetica(n1,n2,n3));
		}else if(opcao == 2) {
			System.out.println(mediaPonderada(n1,n2,n3));
		}else if(opcao == 3) {
			System.out.println(mediaHarmonica(n1,n2,n3));
		}

	}

	public static void mediaHarmonica(float n1, float n2, float n3) {
		
		
	}

	public static float mediaPonderada(float n1, float n2, float n3) { // peso 3,3,4
		float media = (n1 * 3f + n2 * 3f + n3 * 4f) / 10f;
		return media;
		
	}

	public static float mediaAritmetica(float n1, float n2, float n3) {
		float media = (n1+n2+n3) / 3f;
		return media;
		
	}

	

}
