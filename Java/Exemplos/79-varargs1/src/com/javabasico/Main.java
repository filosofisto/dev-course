package com.javabasico;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		out.printf(
				"A média é %f\nA outra é %f\nSem nenhum valor eh %f\n", 
				media(10f, 4f),
				media(1, 5, 6, 7, 9, 15),
				media());
		
		media("Resultado da Media", 1, 2, 3);
	}
	
	static float media(float... valores) {
		if (valores.length == 0)
			return 0f;
		
		float soma = 0f;
		
		for (int i = 0; i < valores.length; i++) {
			soma += valores[i];
		}
		
		return soma/valores.length;
	}

	static void media(String label, float... valores) {
		float soma = 0f;
		float result = 0f;
		
		for (int i = 0; i < valores.length; i++) {
			soma += valores[i];
		}

		if (valores.length > 0)
			result = soma/valores.length;
		
		out.printf(label + ": %.2f\n", result);
	}
}
