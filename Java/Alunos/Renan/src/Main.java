import static java.lang.System.out;
import static java.lang.System.err;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Main {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {

		final int quantidade_exercicios = 12;
		int exe;

		do {
			out.print("\n\n" + "\t================================" + "\t| Lista de Exerc�cio 03 � Java |"
					+ "\t================================" + "\n\n\t Selecione o Exerc�cio da Lista que gostaria de ver"
					+ "\n\t" + "\n\t Insira 0 para encerrar a aplica��o" + "\n\t > ");
			try {
				exe = in.nextInt();
			} catch (Exception e) {
				err.print("\n\t ERRO: O valor inserido n�o � inteiro.");
				exe = 0;
			}

			if (exe > quantidade_exercicios) {
				out.println("A lista s� tem " + quantidade_exercicios + " exerc�cios.");
			} else if (exe < 0) {
				out.println("ERRO: O usu�rio forneceu um n�mero negativo para o n�mero do exerc�cio.");
			} else {

				out.print("\n\t Exerc�cio no." + exe + "\n\t");

				// Exerc�cio listados
				in.nextLine();
				switch (exe) {
				case 0:
					out.println("Ok.");
					break;
				case 1:
					out.print("Ok.");
					break;
				case 3:
					out.println(
							"Construa um programa que leia do console 3 n�meros inteiros, e imprima o resultado em ordem crescente");
					exe03();
					break;
				case 4:
					out.println(
							"Construa um programa que leia a partir do console a idade de uma pessoa expressa em anos, meses e dias e imprima no console a idade expressa apenas em dias.");
					exe04();
					break;
				case 5:
					out.println(
							"Construa um programa que leia a partir do console as 3 notas de um aluno e calcule a m�dia final deste aluno, considerando m�dia aritm�tica simples.");
					exe05();
					break;
				case 6:
					out.println(
							"Construa um programa que leia a partir do console as 3 notas de um aluno e calcule a m�dia final deste aluno. Considerar que a m�dia � ponderada e que o peso das notas s�o 2,3 e 5, respectivamente.");
					exe06();
					break;
				default:
					out.println("Exerc�cio n�o listado.");
				}
			}

			Thread.sleep(1500);

		} while (exe != 0);

	}

	// Exerc�cio 3
	public static void exe03() {
		out.println("tInforme tr�s valores n�meros \t (pressione enter para cada valor informado");

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

	// Exerc�cio 4
	public static void exe04() {
		out.println("Insira a sua idade expressa em anos, meses e dias:");
		int anos = in.nextInt();
		int meses = in.nextInt();
		int dias = in.nextInt();

		out.println("Sua idade � de " + (anos * 360 + meses * 30 + dias) + " dias.");

	}

	// Exerc�cio 5
	public static void exe05() {
		out.println("Insira as 3 notas do aluno:");
		int[] notas = new int[] { in.nextInt(), in.nextInt(), in.nextInt() };
		out.println("A m�dia deste aluno � " + calcularMedia(notas) + ".");

	}

	// Exerc�cio 6
	public static void exe06() {
		out.println("Insira as 3 notas do aluno:");
		int[] notas = new int[] { in.nextInt(), in.nextInt(), in.nextInt() };
		out.println(" O peso de cada nota, respectivamente, � 2, 3 e 5" + "\n A m�dia final aluno � "
				+ calcularMedia(notas) + ".");

	}

	// Met�dos...
	public static int calcularMedia(int[] valores) {
		int soma = 0;
		for (int valor : valores) {
			soma += valor;
		}

		return soma / valores.length;
	}

	public static int calcularMediaPonderada(int[] valores, int[] pesos) {
		if (valores.length != pesos.length) {
			throw new Error("A quantidade de pesos � diferente da quantidade de valores");
		} else {
			
			int total_pesos = 0;
			int soma = 0;
			
			for (int peso : pesos) {
				total_pesos += peso;
			}
			
			for() {
				
			}

			return soma / valores.length;
		}
	}

	public static int[] ordenar(int[] vetor) {
		return ordenar(vetor, true);
	}

	public static int[] ordenar(int[] vetor, boolean crescente) {
		if (crescente) {
			// Crescente
			for (int i = 0; i < vetor.length; i++) {
				for (int j = i + 1; j < vetor.length; j++) {
					if (vetor[j] < vetor[i]) {
						int temp = vetor[j];
						vetor[j] = vetor[i];
						vetor[i] = temp;
					}
				}
			}
		} else {
			// Decrescente
			for (int i = 0; i < vetor.length; i++) {
				for (int j = i + 1; j < vetor.length; j++) {
					if (vetor[j] > vetor[i]) {
						int temp = vetor[j];
						vetor[j] = vetor[i];
						vetor[i] = temp;
					}
				}
			}
		}
		return vetor;
	}
}
