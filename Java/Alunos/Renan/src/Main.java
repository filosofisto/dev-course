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
					+ "\t| Lista de Exerc�cio 03 � Java |"
					+ "\t================================"
					+ "\n\n\t Insira um valor entre 1 e 13 para selecionar o exerc�cio."
					+ "\n\t Insira 0 para encerrar a aplica��o");
			try {
				exe = in.nextInt();
			} catch (Exception e) {
				err.print("\n\t ERRO: O valor inserido n�o � inteiro.");
				exe = 0;
			}

			if (exe > 13) {
				out.println("A lista s� tem 13 exerc�cios.");
			} else if (exe < 0) {
				out.println("ERRO: O usu�rio forneceu um n�mero negativo para o n�mero do exerc�cio.");
			} else {
				// Exerc�cio listados
				in.nextLine();
				switch (exe) {
				case 0:
					out.println("Aplica��o Encerrada.");
				case 1:
					exe01();
					break;
				default:
					out.println("Exerc�cio n�o listado.");
				}
			}

			Thread.sleep(1500);;
		} while (exe != 0);

	}

	public static void exe01() {
		out.println("Informe tr�s valores n�meros \t (pressione enter para cada valor informado");

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
