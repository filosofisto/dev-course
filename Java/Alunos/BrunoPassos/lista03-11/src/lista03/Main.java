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

		int[] vetor = new int[100000000];
		int valoresAleatorios;
		Random random = new Random();
		
		
		//popula o array
		for (int i = 0; i < vetor.length; i++) {
			valoresAleatorios = random.nextInt(100000000) + 1;
			vetor[i] = valoresAleatorios;
		}
		
		//realiza busca de um numero aleatoriamente, e verifica se existe o numero
		valoresAleatorios = random.nextInt(100000000) + 1;
		int posicaoEncontrada = -1;
		
		long t1 = System.currentTimeMillis();
		
		for(int i=0; i < vetor.length /*&& posicaoEncontrada == -1*/;i++) {
			if(vetor[i] == valoresAleatorios) {
				posicaoEncontrada = i;
				break;
			}
		}
		
		long t2 = System.currentTimeMillis();

		if (posicaoEncontrada > -1) {
			System.out.println("Valor encontrado na posicao: " + posicaoEncontrada);
		} else {
			System.out.println("Numero nao encontrado !");
		}
		
		System.out.println("Tempo de Processamento: " + (t2-t1) + " ms");
	}
}
