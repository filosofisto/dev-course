package Lista03;

import static java.lang.System.out;
import model.funcao;

import static java.lang.System.err;

import java.util.Random;
import java.util.Scanner;

public class Lista03 {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {

		final int quantidade_exes = 13;
		int exe;

		out.println("\t======================================" + "\n\t|	Lista de Exercícios 03 - Java	|"
				+ "\n\t======================================");

		do {
			try {
				exe = Integer.parseInt(args[0]);
				out.println("\n\tPressione [ENTER] para continuar...");
				in.nextLine();
			} catch (Exception e) {
				out.print("\t Selecione um exercício entre 1 e " + quantidade_exes
						+ "\n\t Ou insira 0 para encerrar a aplicação." + "\n\t > ");
				exe = in.nextInt();
			}

			if (exe > 0 && exe <= quantidade_exes) {
				out.print("\n\t Exercício no." + exe);
				Thread.sleep(1500);

				switch (exe) {
				case 1:
					exercicios.exe01();
					break;
				case 2:
					exercicios.exe02();
					break;
				case 3:
					exercicios.exe03(args);
					break;
				case 4:
					exercicios.exe04(args);
					break;
				case 5:
					exercicios.exe05(args);
					break;
				case 6:
					exercicios.exe06(args);
					break;
				case 7:
					exercicios.exe07();
					break;
				case 8:
					exercicios.exe08(args);
					break;
				default:
					out.println("\n\t Exercício não listado.");
				}
			} else {
				// Valor inválido
				err.println("\n\t Valor inválido inserido para selecionar um exercício.");
			}

			out.print("\n\n\t");
			Thread.sleep(1500);
			for (int i = 0; i < 3; i++) {
				Thread.sleep(350);
				out.print(" . ");
				Thread.sleep(350);
			}
			out.println("\n");
		} while (exe != 0);

	}

	static class exercicios {
		protected static int[] exe01() {

			int seq[] = new int[50];

			for (int i = 0; i < seq.length; i++) {
				seq[i] = i + 1;
			}

			out.println("\n\t Imprimindo sequência de números de 1 a 50 em ordem crescente: ");
			for (int numero : seq) {
				out.println("\t\t [\t" + numero + "\t]");
			}
			out.println("\n\t Imprimindo sequência de números de 1 a 50 em ordem decrescente: ");
			for (int i = seq.length - 1; i >= 0; i--) {
				out.println("\t\t [\t" + seq[i] + "\t]");
			}

			return seq;
		}

		protected static void exe02() {
			int seq[] = new int[50];

			for (int i = 0; i < seq.length; i++) {
				seq[i] = i + 1;
			}

			out.println("\n\t Imprimindo somente os números pares entre 1 e 50:");
			for (int numero : seq) {
				if (numero % 2 == 0) {
					out.println("\t\t [\t" + numero + "\t]");
				}
			}
		}

		protected static float exe03(String args[]) {
			float x = 0;
			float y = 0;
			try {
				x = Float.parseFloat(args[1]);
				y = Float.parseFloat(args[2]);
			} catch (Exception e) {
				out.println("\n\t Insira os valores de x e y:");
				x = in.nextFloat();
				y = in.nextFloat();
			} finally {
				out.print("\n\t Valores inseridos: ");
				out.print("\n\t x\t=\t " + x);
				out.print("\n\t y\t=\t " + y);
			}

			out.print("\n\n\t O valor de x elevado a y:");
			float resultado = (float) Math.pow(x, y);

			out.println("\n\t " + x + "^" + y + "\t=\t " + resultado);

			return resultado;
		}

		protected static int exe04(String args[]) {
			int n = 0;
			try {
				n = Integer.parseInt(args[1]);
			} catch (Exception e) {
				Random r = new Random();
				n = r.nextInt(21); // r.nextInt(MAXIMO + 1 - MINIMO);
			}

			int resultado = funcao.fatorial(n);
			out.print("\n\t O fatorial de " + n + " é " + resultado + ".");

			return resultado;
		}

		protected static float exe05(String args[]) {
			float[] n = new float[2];

			try {
				n[0] = Float.parseFloat(args[1]);
				n[1] = Float.parseFloat(args[2]);
			} catch (Exception e) {
				out.println("\n\t Insira dois números: ");
				n[0] = in.nextFloat();
				n[1] = in.nextFloat();
			}

			float soma = n[0] + n[1];
			out.println("\n\t A soma de " + n[0] + " e " + n[1] + " é " + soma + ".");

			return soma;
		}

		protected static boolean exe06(String args[]) {
			int n = 0;
			try {
				n = Integer.parseInt(args[1]);
			} catch (Exception e) {
				out.print("\n\t Insira um número inteiro qualquer: ");
				n = in.nextInt();
			}

			boolean primo = funcao.primo(n);

			if (primo) {
				out.print("\t " + n + " é Primo!");
			} else {
				out.print("\t " + n + " NÃO é Primo!");
			}

			return primo;

		}

		protected static double exe07() {

			out.println("\n\t Calculando o valorde H," + "\n\t Dado H = 1 + 3/2 + 5/3 + 7/4 + ... + 99/50"
					+ "\n\t      H = Σ (2*n+1)/(2*n)"
					+ "\n\t Sendo o 2*n para sequencias pares, e (2*n+1) para sequencias impares.");

			double h = 1;

			out.print("\n\t H = 1 ");
			for (double n = 1; 2 * n <= 50; n++) {
				double valor = (2 * n + 1) / (2 * n);
				out.print("+ " + valor);
				h += valor;
			}
			out.println("\n\t H = " + h);

			return h;
		}

		protected static void exe08(String args[]) {
			out.println(
					"\n\t Dado uma série infinita (fórmula abaixo), e calcule o valor da série até atingir a precisão de 0,001."
							+ "\n\t X = 1 + 1/2 + 1/4 + ...");

			exe08series(0.001);
			exe08series(0.000001);
		}

		private static void exe08series(double precisao) {
			double x = 1;
			double x_anterior = 0;
			double denominador = 2;

			out.print("\n\n\tPrecisão: " + precisao);

			out.print("\n\t X = 1");
			do {
				x_anterior = x;
				x += 1 / denominador;
				out.print(" + 1/" + denominador + " (=" + x + ")");
				denominador *= 2;
			} while (x - x_anterior > precisao);

			out.print("\n\t X Atual: " + x);
			out.print("\n\t X Anterior: " + x);
			out.print("\n\t Denominador: " + denominador);
		}

		protected static void exe09(String args[]) {
			try {
				double precisao = Double.parseDouble(args[1]);

				out.println("\n\t Calculando o valor de π com precisão de " + precisao);
				out.println("\n\t π ≈ " + funcao.pi(precisao));

			} catch (Exception e) {

				out.println("\n\t Calculando o valor de π com precisão de 0.01 .");
				out.println("\n\t π ≈ " + funcao.pi(0.01));

				out.println("\n\t Calculando o valor de π com precisão de 0.0001 .");
				out.println("\n\t π ≈ " + funcao.pi(0.0001));
			} finally {
				out.println(
						"\n\t Formula usada para calcular o valor de π (pí):" + "\n\t π/4 = 1 - 1/3 + 1/5 - 1/7 + ..."
								+ "\n\t resumido em " + "\n\t π/4 = 1 + Σ (-1^n) * 1/(2*n+1)");
			}

		}

	}
}
