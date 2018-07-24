import static java.lang.System.out;
import static java.lang.System.err;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Main {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {

		int exe;

		do {
			out.println("\n\n"
					+ "\t================================" 
					+ "\t| Lista de Exercício 03 – Java |"
					+ "\t================================"
					+ "\n\n\t Insira um valor entre 1 e 13 para selecionar o exercício."
					+ "\n\t Insira 0 para encerrar a aplicação");
			try {
				exe = in.nextInt();
			} catch (Exception e) {
				err.print("\n\t ERRO: O valor inserido não é inteiro.");
				exe = 0;
			}

			if (exe > 13) {
				out.println("A lista só tem 13 exercícios.");
			} else if (exe < 0) {
				out.println("ERRO: O usuário forneceu um número negativo para o número do exercício.");
			} else {
				// Exercício listados
				in.nextLine();
				switch (exe) {
				case 0:
					out.println("Aplicação Encerrada.");
				case 1:
					exe01();
					break;
				default:
					out.println("Exercício não listado.");
				}
			}

			Thread.sleep(1500);;
		} while (exe != 0);

	}

	public static void exe01() {
		out.println("Informe três valores números \t (pressione enter para cada valor informado");

		String valores[] = new String[] { in.nextLine(), in.nextLine(), in.nextLine() };

		out.println("Convertendo os valores (String para int)...");

		int inteiros[] = new int[valores.length];

		for (int i = 0; i < valores.length; i++) {
			inteiros[i] = Integer.parseInt(valores[i]);
		}

		out.println("Determinando a ordem... ");
		inteiros = ordenar(inteiros);

		out.println("Valor inseridos em ordem crescente: ");
		for (int valor : inteiros) {
			out.println(valor);
		}
	}

	public static int[] ordenar(int[] vetor) {
		return ordenar(vetor, true);
	}

	public static int[] ordenar(int[] vetor, boolean crescente) {
		for (int i = 0; i < vetor.length; i++) {
			for (int j = i + 1; j < vetor.length; j++) {
				if (vetor[j] < vetor[i]) {
					int temp = vetor[j];
					vetor[j] = vetor[i];
					vetor[i] = temp;
				}
			}
		}
		return vetor;
	}
}
