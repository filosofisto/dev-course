package lista02;

import java.util.Scanner;

public class Main {

	/*
	 * 11. Um usu�rio deseja um algoritmo onde possa escolher que tipo de m�dia
	 * deseja calcular a partir de 3 notas. Fa�a um programa que leia a partir do
	 * console as notas, a op��o escolhida pelo usu�rio e calcule o resultado.
	 * Op��es: (1) aritm�tica, (2) ponderada [valores da pondera��o: 3,3,4] e (3)
	 * harm�nica.
	 */

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Informe o valor de 3 notas");
		float n1 = scan.nextFloat();
		float n2 = scan.nextFloat();
		float n3 = scan.nextFloat();
		
		System.out.println("Informe qual op��o deseja para ser realizado o calculo\n"
				+"Opcao 1 > Media Aritmetica\n"
				+ "Opcao 2 > Media Ponderada\n"
				+ "Opcao 3 > Media Harmonica\n");
		int opcao = scan.nextInt();
		
		if(opcao < 1 || opcao > 3) {
			System.out.println("Opcao invalida");
		}else if(opcao == 1) {
			System.out.println("A media aritmetica �: " + mediaAritmetica(n1,n2,n3));
		}else if(opcao == 2) {
			System.out.println(mediaPonderada(n1,n2,n3));
		}else if(opcao == 3) {
			System.out.println(mediaHarmonica(n1,n2,n3));
		}

	}

	public static float mediaHarmonica(float n1, float n2, float n3) {
		return 3/((1/n1)+(1/n2)+(1/n3));
		
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
