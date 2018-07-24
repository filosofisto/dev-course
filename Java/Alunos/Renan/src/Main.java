import static java.lang.System.out;
import static java.lang.System.err;

import java.util.Random;
import java.util.Scanner;

public class Main {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {

		final int quantidade_exercicios = 12;
		int exe;

		do {
			out.print("\n\n\t================================" + "\n\t| Lista de Exerc�cio 02 � Java |"
					+ "\n\t================================" + "\n\n\t Insira valores de 1 a " + quantidade_exercicios
					+ " para ver o respectivo exerc�cio." + "\n\t Insira 0 para encerrar a aplica��o." + "\n\t > ");
			try {
				exe = in.nextInt();
			} catch (Exception e) {
				err.print("\n\t ERRO: O valor inserido n�o � inteiro.");
				exe = 0;
			}
			out.println();
			if (exe > quantidade_exercicios) {
				out.println("A lista s� tem " + quantidade_exercicios + " exerc�cios.");
			} else if (exe > 0) {

				out.print("\n\t Exerc�cio no." + exe + "\n\t");

				// Exerc�cio listados
				in.nextLine();
				switch (exe) {
				case 1:
					out.println("Ok.");
					break;
				case 2:
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
				case 7:
					out.println(
							"O custo ao consumidor de um carro novo � a soma do custo de f�brica somados a percentagem do distribuidor e dos impostos (aplicados ao custo de f�brica). Supondo que a percentagem do distribuidor seja de 1,8% e os impostos de 45%, escrever um programa que leia do console o custo de f�brica de um carro e imprima o custo final");
					exe07();
					break;
				case 8:
					out.println(
							"Construa um programa que calcule a m�dia aritm�tica das 3 notas de um aluno e mostre, al�m do valor da m�dia, uma mensagem de \"Aprovado\", caso a m�dia seja igual ou superior a 6, ou a mensagem \"reprovado\", caso contr�rio. Ao inv�s de ler as notas do console, sorteie (randomicamente) valores inteiros de 1 a 10.");
					exe08();
					break;
				case 9:
					out.println(
							"Elaborar um programa que l� 2 n�meros e imprime a mensagem: \"S�o m�ltiplos\" ou \"N�o s�o m�ltiplos�.");
					exe09();
					break;
				case 10:
					out.println(
							"Elabore um programa que dada a idade de um nadador classifica-o em uma das seguintes categorias:");
					exe10();
					break;
				default:
					out.println("Exerc�cio n�o listado.");
				}
			}

			Thread.sleep(1500);

		} while (exe != 0);

		out.println("Fim da Aplica��o");
		System.exit(0);
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
		float[] notas = new float[] { in.nextFloat(), in.nextFloat(), in.nextFloat() };
		out.println("A m�dia deste aluno � " + calcularMedia(notas) + ".");

	}

	// Exerc�cio 6
	public static void exe06() {
		out.println("Insira as 3 notas do aluno:");
		float[] notas = new float[] { in.nextFloat(), in.nextFloat(), in.nextFloat() };
		out.println("O peso de cada nota, respectivamente, � 2, 3 e 5.");
		float[] pesos = new float[] { 2, 3, 5 };
		out.println("A m�dia final (ponderada) do aluno � " + calcularMediaPonderada(notas, pesos) + ".");

	}

	// Exerc�cio 7
	public static void exe07() {
		out.println("Insira o custo de fabrica de um carro: ");
		float preco = in.nextFloat();

		final float distribuidor = 0.018f; // 1.8%
		final float impostos = 0.45f; // 45%

		// Pre�o Final = Pre�o + (% do Distribuidor + % de Impostos) * Pre�o
		float preco_final = (preco + (distribuidor + impostos) * preco);

		out.println("O custo final de um carro � " + preco_final + ".");
	}

	// Exerc�cio 8
	public static void exe08() {

		out.println("Sorteando as 3 notas de um aluno... ");

		Random r = new Random();

		float[] notas = new float[] { (r.nextInt(10) + r.nextFloat()), (r.nextInt(10) + r.nextFloat()),
				(r.nextInt(10) + r.nextFloat()) };

		out.println("As notas sorteads foram: ");
		for (float nota : notas) {
			out.println(nota);
		}

		out.println("Calculando a m�dia... ");
		float media = calcularMedia(notas);

		out.println("A m�dia deste aluno � " + media + ".");

		if (media >= 6) {
			out.println("Aprovado!");
		} else {
			out.println("Reprovado!");
		}
	}

	// Exerc�cio 9
	public static void exe09() {
		out.println("Insira dois n�meros: ");
		float[] n = new float[] { in.nextFloat(), in.nextFloat() };

		if (n[0] % n[1] == 0) {
			out.println("\t " + n[0] + " � m�ltiplo de " + n[1] + ".");
		} else if (n[1] % n[0] == 0) {
			out.println("\t " + n[1] + " � m�ltiplo de " + n[0] + ".");
		} else {
			out.println("\t Nenhum n�mero � m�ltiplo do outro.");
		}

	}

	//	Exerc�cio 10
	public static void exe10() {
		out.println("Insira a idade de um nadador: ");
		int idade = in.nextInt();

		if (5 >= idade && idade <= 7) {
			out.println("Infantil A");
		} else if (8 <= idade && idade <= 10) {
			out.println("Infantil B");
		} else if (11 <= idade && idade <= 13) {
			out.println("Juvenil A");
		} else if (14 <= idade && idade <= 17) {
			out.println("Juvenil B");
		} else if (idade >= 18) {
			out.println("Adulto");
		} else {
			out.println("N�o existem categorias para esta idade");
		}

	}

//	Outros Met�dos ...
	public static float calcularMedia(float[] valores) {
		float soma = 0;
		for (float valor : valores) {
			soma += valor;
		}

		return soma / valores.length;
	}

	public static float calcularMediaPonderada(float[] valores, float[] pesos) {
		if (valores.length != pesos.length) {
			throw new Error("A quantidade de pesos � diferente da quantidade de valores");
		} else {

			float total_pesos = 0;
			float soma = 0;

			for (float peso : pesos) {
				total_pesos += peso;
			}

			for (int i = 0; i < valores.length; i++) {
				soma += valores[i] * pesos[i];
			}

			return soma / total_pesos;
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
			for (int i = vetor.length; i >= 0; i--) {
				for (int j = vetor.length - 1; j >= 0; j--) {
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
