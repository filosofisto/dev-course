package lista03;

import java.util.Random;

public class Main {

	/*
	 * 11. Fa�a um programa que popule um array de 100 posi��es com valores
	 * aleat�rios entre 1 e 100, pesquise um n�mero (definido tamb�m aleatoriamente)
	 * dentro do array e caso encontre o n�mero desejado, imprima a posi��o que o
	 * mesmo se encontra ou informe que o mesmo n�o existe. Exiba tamb�m o tempo de
	 * processamento em milissegundos.
	 */
	public static void main(String[] args) {

		int[] vetor = new int[100];
		int valoresAleatorios;
		Random random = new Random();
		
		
		//popula o array
		for (int i = 0; i < vetor.length; i++) {
			valoresAleatorios = random.nextInt(100) + 1;
			vetor[i] = valoresAleatorios;
		}
		
		//realiza busca de um numero aleatoriamente, e verifica se existe o numero
		for(int i=0; i<vetor.length;i++) {
			valoresAleatorios = random.nextInt(100) + 1;
			if(vetor[i] == valoresAleatorios) {
				System.out.println("Valor escolhido: " + valoresAleatorios);
			}else {
				System.out.println("Numero n�o encontrado !");
			}
			
		}
		
	}

}
