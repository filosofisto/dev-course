package model;

import static java.lang.System.out;

import java.util.Scanner;

public class Console {
	public static Scanner in;

	public static void prepararScanner() {
		if (in == null) {
			in = new Scanner(System.in);
		}
	}

	public static void exibir(boolean confirmacao, String... mensagens) {
		out.println();
		for (String m : mensagens) {
			out.println("\t " + m);
		}

		if (confirmacao) {
			out.println("\t Pressione [ENTER] para continuar.");
			prepararScanner();
			in.nextLine();
		}
	}

	public static void exibir(String... mensagens) {
		exibir(false, mensagens);
	}

	public static String ler(String mensagem) {
		out.print("\t" + mensagem + ":\t");
		prepararScanner();
		return in.nextLine();
	}

	public static String[] ler(String... enunciados) {
		String[] valores = new String[enunciados.length];
		for (int i = 0; i < enunciados.length; i++) {
			valores[i] = ler(enunciados[i]);
		}
		return valores;
	}

	public static boolean confirmar(String mensagem) {
		out.print("\t" + mensagem+" (s/n) ");
		prepararScanner();
		char resposta = in.nextLine().toLowerCase().charAt(0);
		return (resposta == 's' || resposta == 'y');
	}

	public void finalize() {
		if (in != null) {
			try {
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
