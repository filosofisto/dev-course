package lista02;

import java.util.Random;

public class Main {

	/*
	 * 8. Construa um programa que calcule a m�dia aritm�tica das 3 notas de um
	 * aluno e mostre, al�m do valor da m�dia, uma mensagem de "Aprovado", caso a
	 * m�dia seja igual ou superior a 6, ou a mensagem "reprovado", caso contr�rio.
	 * Ao inv�s de ler as notas do console, sorteie (randomicamente) valores
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
