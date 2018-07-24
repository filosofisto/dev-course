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
			out.print("\n\n\t================================" + "\n\t| Lista de Exercício 02 – Java |"
					+ "\n\t================================" + "\n\n\t Insira valores de 1 a " + quantidade_exercicios
					+ " para ver o respectivo exercício." + "\n\t Insira 0 para encerrar a aplicação." + "\n\t > ");
			try {
				exe = in.nextInt();
			} catch (Exception e) {
				err.print("\n\t ERRO: O valor inserido não é inteiro.");
				exe = 0;
			}
			out.println();
			if (exe > quantidade_exercicios) {
				out.println("A lista só tem " + quantidade_exercicios + " exercícios.");
			} else if (exe > 0) {

				out.print("\n\t Exercício no." + exe + "\n\t");

				// Exercício listados
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
							"Construa um programa que leia do console 3 números inteiros, e imprima o resultado em ordem crescente");
					exe03();
					break;
				case 4:
					out.println(
							"Construa um programa que leia a partir do console a idade de uma pessoa expressa em anos, meses e dias e imprima no console a idade expressa apenas em dias.");
					exe04();
					break;
				case 5:
					out.println(
							"Construa um programa que leia a partir do console as 3 notas de um aluno e calcule a média final deste aluno, considerando média aritmética simples.");
					exe05();
					break;
				case 6:
					out.println(
							"Construa um programa que leia a partir do console as 3 notas de um aluno e calcule a média final deste aluno. Considerar que a média é ponderada e que o peso das notas são 2,3 e 5, respectivamente.");
					exe06();
					break;
				case 7:
					out.println(
							"O custo ao consumidor de um carro novo é a soma do custo de fábrica somados a percentagem do distribuidor e dos impostos (aplicados ao custo de fábrica). Supondo que a percentagem do distribuidor seja de 1,8% e os impostos de 45%, escrever um programa que leia do console o custo de fábrica de um carro e imprima o custo final");
					exe07();
					break;
				case 8:
					out.println(
							"Construa um programa que calcule a média aritmética das 3 notas de um aluno e mostre, além do valor da média, uma mensagem de \"Aprovado\", caso a média seja igual ou superior a 6, ou a mensagem \"reprovado\", caso contrário. Ao invés de ler as notas do console, sorteie (randomicamente) valores inteiros de 1 a 10.");
					exe08();
					break;
				case 9:
					out.println(
							"Elaborar um programa que lê 2 números e imprime a mensagem: \"São múltiplos\" ou \"Não são múltiplos”.");
					exe09();
					break;
				case 10:
					out.println(
							"Elabore um programa que dada a idade de um nadador classifica-o em uma das seguintes categorias:");
					exe10();
					break;
				default:
					out.println("Exercício não listado.");
				}
			}

			Thread.sleep(1500);

		} while (exe != 0);

		out.println("Fim da Aplicação");
		System.exit(0);
	}

	// Exercício 3
	public static void exe03() {
		out.println("tInforme três valores números \t (pressione enter para cada valor informado");

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

	// Exercício 4
	public static void exe04() {
		out.println("Insira a sua idade expressa em anos, meses e dias:");
		int anos = in.nextInt();
		int meses = in.nextInt();
		int dias = in.nextInt();

		out.println("Sua idade é de " + (anos * 360 + meses * 30 + dias) + " dias.");

	}

	// Exercício 5
	public static void exe05() {
		out.println("Insira as 3 notas do aluno:");
		float[] notas = new float[] { in.nextFloat(), in.nextFloat(), in.nextFloat() };
		out.println("A média deste aluno é " + calcularMedia(notas) + ".");

	}

	// Exercício 6
	public static void exe06() {
		out.println("Insira as 3 notas do aluno:");
		float[] notas = new float[] { in.nextFloat(), in.nextFloat(), in.nextFloat() };
		out.println("O peso de cada nota, respectivamente, é 2, 3 e 5.");
		float[] pesos = new float[] { 2, 3, 5 };
		out.println("A média final (ponderada) do aluno é " + calcularMediaPonderada(notas, pesos) + ".");

	}

	// Exercício 7
	public static void exe07() {
		out.println("Insira o custo de fabrica de um carro: ");
		float preco = in.nextFloat();

		final float distribuidor = 0.018f; // 1.8%
		final float impostos = 0.45f; // 45%

		// Preço Final = Preço + (% do Distribuidor + % de Impostos) * Preço
		float preco_final = (preco + (distribuidor + impostos) * preco);

		out.println("O custo final de um carro é " + preco_final + ".");
	}

	// Exercício 8
	public static void exe08() {

		out.println("Sorteando as 3 notas de um aluno... ");

		Random r = new Random();

		float[] notas = new float[] { (r.nextInt(10) + r.nextFloat()), (r.nextInt(10) + r.nextFloat()),
				(r.nextInt(10) + r.nextFloat()) };

		out.println("As notas sorteads foram: ");
		for (float nota : notas) {
			out.println(nota);
		}

		out.println("Calculando a média... ");
		float media = calcularMedia(notas);

		out.println("A média deste aluno é " + media + ".");

		if (media >= 6) {
			out.println("Aprovado!");
		} else {
			out.println("Reprovado!");
		}
	}

	// Exercício 9
	public static void exe09() {
		out.println("Insira dois números: ");
		float[] n = new float[] { in.nextFloat(), in.nextFloat() };

		if (n[0] % n[1] == 0) {
			out.println("\t " + n[0] + " é múltiplo de " + n[1] + ".");
		} else if (n[1] % n[0] == 0) {
			out.println("\t " + n[1] + " é múltiplo de " + n[0] + ".");
		} else {
			out.println("\t Nenhum número é múltiplo do outro.");
		}

	}

	//	Exercício 10
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
			out.println("Não existem categorias para esta idade");
		}

	}

//	Outros Metódos ...
	public static float calcularMedia(float[] valores) {
		float soma = 0;
		for (float valor : valores) {
			soma += valor;
		}

		return soma / valores.length;
	}

	public static float calcularMediaPonderada(float[] valores, float[] pesos) {
		if (valores.length != pesos.length) {
			throw new Error("A quantidade de pesos é diferente da quantidade de valores");
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
