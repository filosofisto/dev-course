package lista02;

import java.util.Scanner;

public class Main {

	/*
	 * 1. Construa um programa que leia a partir do console as 3 notas de um aluno e
	 * calcule a média final deste aluno. Considerar que a média é ponderada e que o
	 * peso das notas são 2,3 e 5, respectivamente.
	 */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Informe 3 notas de um aluno: (Pressionar enter apos inserção da note)");
		float nota1 = scan.nextFloat();
		float nota2 = scan.nextFloat();
		float nota3 = scan.nextFloat();
		
		float media = (nota1 * 2f + nota2 * 3f + nota3 * 5f) / 10f;
		
//		System.out.println("A média do aluno é: " + media);
		
		System.out.printf("A média do aluno é: %.2f", media);
	}

}
