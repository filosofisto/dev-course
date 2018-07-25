package lista03;

public class Main {

	// 1. Construa um programa que imprime os números de 1 a 50 em ordem crescente e
	// também em ordem decrescente.

	public static void main(String[] args) {

		int vetor[] = new int[50];
		int count = 1;

		System.out.println("Ordem Crescente\n" + "");
		// preenche o vetor
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = count;
			count++;
			// imprimi em crescente
			System.out.println(vetor[i]);

		}
		System.out.println("");
		System.out.println("Ordem Descrecente\n" + "");
		// imprimir em decrescente
		for (int a = vetor.length - 1; a >= 0; a--) {
			System.out.println(vetor[a]);
		}

	}

}
