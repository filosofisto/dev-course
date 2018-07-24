package lista02;

import java.util.Random;

public class Main {

	/*
	 * 8. Construa um programa que calcule a média aritmética das 3 notas de um
	 * aluno e mostre, além do valor da média, uma mensagem de "Aprovado", caso a
	 * média seja igual ou superior a 6, ou a mensagem "reprovado", caso contrário.
	 * Ao invés de ler as notas do console, sorteie (randomicamente) valores
	 * inteiros de 1 a 10.
	 */

	public static void main(String[] args) {
		
		Random random = new Random();
		
		int n1 = random.nextInt(10) +1;
		int n2 = random.nextInt(10) +1;
		int n3 = random.nextInt(10) +1;
		
		float media = (n1+n2+n3) /3f;
		
		if(media >=6) {
			System.out.println("");
		}

	}

}
