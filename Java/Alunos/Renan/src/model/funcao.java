package model;

public final class funcao {

	public static int fatorial(int n) {
		

		if (n == 1) {
			return 1;
		} else {
			int fat = fatorial(n - 1) * n;
			return fat;
		}
	}

	public static double pi(double precisao) {
		// Para calcular o valor de Pí
		// π/4 = 1 - 1/3 + 1/5 - 1/7 + ...

		double quartoDePi = 0;
		double quartoDePiAnerior = -1;
		int denominador = 1;
		int sinal = 1;

		while (Math.abs(quartoDePi - quartoDePiAnerior) > precisao) {
			quartoDePiAnerior = quartoDePi;

			quartoDePi += sinal * 1d / denominador;

			denominador += 2;
			sinal = -sinal;

		}

		double pi = 4 * quartoDePi;

		return pi;
	}

	public static boolean primo(int num) {

		if (num == 0) {
			// O 0 possui infinitos divisores.
			return false;
		} else if (num == 1) {
			// O 1 não é considerado um número primo.
			return false;
		} else {
			if (num < 0) {
				/**
				 * Se você estender a definição de número primo para todos os inteiros, então um
				 * número negativo é primo se o seu oposto for primo.
				 * 
				 * A definição de números primos para os inteiros engloba tanto números
				 * positivos como negativos: número primo é um número inteiro que admite
				 * exatamente 4 divisores.
				 * 
				 * Portanto, caso recebessemos um negativo, bastaria inverter o sinal e ver se o
				 * seu oposto é primo.
				 */
				num *= -1;
			}

			boolean primo = true;

			// Conferindo se é primo
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					// Se confirmado se o número possui algum divisor
					primo = false;
					i = num;
				}
			}

			return primo;
		}
	}

}
