package model;

public final class Estatistica {
	
	private Estatistica() {
		
	}

	public static double mediaAritetica(double[] valores) {
		if (valores.length == 0)
			return 0;
		
		double soma = 0;
		for (double valor : valores) {
			soma = +valor;
		}
		return soma / valores.length;
	}

	public static float mediaAritetica(float[] valores) {
		if (valores.length == 0)
			return 0;
		
		float soma = 0;
		for (float valor : valores) {
			soma = +valor;
			//soma += valor;
		}
		return soma / valores.length;
	}

	public static double mediaPonderada(double[] valores, double pesos[]) {
		if (valores.length == 0)
			return 0;
		
		double soma_valores = 0;
		double soma_pesos = 0;
		for (int i = 0; i < valores.length; i++) {
			soma_valores += valores[i] * pesos[i];
			soma_pesos += pesos[i];
		}
		return soma_valores / soma_pesos;
	}

	public static float mediaPonderada(float[] valores, float pesos[]) {
		if (valores.length == 0)
			return 0;
		
		float soma_valores = 0;
		float soma_pesos = 0;
		for (int i = 0; i < valores.length; i++) {
			soma_valores += valores[i] * pesos[i];
			soma_pesos += pesos[i];
		}
		return soma_valores / soma_pesos;
	}

	public static int produtorio(int n) {
		int produtorio = 1;

		for (int i = 0; i < n; i++) {
			int termo = i * (i + 1);
			produtorio *= termo;
		}

		return produtorio;
	}
	
	public static int produtorio(double[] valores) {
		int produtorio = 1;

		for (double valor: valores) {
			produtorio *= valor;
		}

		return produtorio;
	}

	public static double mediana(double[] valores) {
		if (valores.length % 2 == 1) {
			// Tamanho do conjunto � par.
			return (valores[valores.length / 2] + valores[valores.length / 2 + 1]) / 2;
		} else {
			// Tamanho do conjunto � impar.
			return valores[(valores.length / 2) + 1];
		}

	}

	public static float mediana(float[] valores) {
		if (valores.length % 2 == 1) {
			// Tamanho do conjunto � par.
			return (valores[valores.length / 2] + valores[valores.length / 2 + 1]) / 2;
		} else {
			// Tamanho do conjunto � impar.
			return valores[(valores.length / 2) + 1];
		}

	}

	public static int mediana(int[] valores) {
		if (valores.length % 2 == 1) {
			// Tamanho do conjunto � par.
			return (valores[valores.length / 2] + valores[valores.length / 2 + 1]) / 2;
		} else {
			// Tamanho do conjunto � impar.
			return valores[(valores.length / 2) + 1];
		}

	}

	public static double produtorioFlutuante(int n) {
		double produtorio = 1;

		for (double i = 0; i < n; i++) {
			double termo = i * (i + 1);
			produtorio *= termo;
		}
		return produtorio;
	}

	public static double soma(double[] valores) {
		double soma = 0;

		for (double valor : valores) {
			soma += valor;
		}

		return soma;
	}

	public static float soma(float[] valores) {
		float soma = 0;

		for (float valor : valores) {
			soma += valor;
		}

		return soma;
	}

	public static int soma(int[] valores) {
		int soma = 0;

		for (int valor : valores) {
			soma += valor;
		}

		return soma;
	}

}
