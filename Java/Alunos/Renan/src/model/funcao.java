package model;

public class funcao {

	public static int fatorial(int num) {
		int fat = 1;

		for (int i = 1; i <= num; i++) {
			fat = fat * i;
		}
		return fat;
	}
	
	public static double pi(double precisao) {
		
		double pi = 3;
		
		if(precisao  < 0){
			//	Precisão definida corretamente
			double soma = 1;
			
			double valor_atual = 1;
			double valor_anterior;
			
			double n = 2;
			
			/**	Formula para calcular o valor de Pí
			 * 	π/4 = 1 - 1/3 + 1/5 - 1/7 + ...
			 *	resumida em
			 *	π/4 = 1 + Σ (-1^n) * 1/(2*n+1)
			 */
			
			do {
				valor_anterior = valor_atual;
				valor_atual = Math.pow(-1, n) * 1/(2*n+1); 
				soma += valor_atual;
			}while(valor_atual - valor_anterior > precisao);
			
			pi = soma / 4;
		}
		
		return pi;
	}

	public static boolean primo(int num) {

		if(num == 0) {
			//	O 0 possui infinitos divisores.
			return false;
		}else if (num == 1) {
			//	O 1 não é considerado um número primo.
			return false;
		} else {
			if(num < 0) {
				/**
				 * Se você estender a definição de número primo para todos
				 *  os inteiros, então um número negativo é primo se o seu
				 *  oposto for primo.
				 *  
				 * A definição de números primos para os inteiros engloba 
				 *  tanto números positivos como negativos: número primo é
				 *   um número inteiro que admite exatamente 4 divisores.
				 *   
				 *   Portanto, caso recebessemos um negativo, bastaria
				 *    inverter o sinal e ver se o seu oposto é primo.
				 */
				num *= -1;
			}

			boolean primo = true;
			
			//	Conferindo se é primo
			for (int i = 2; i < num; i++) {
				if(num % i == 0) {
					//	Se confirmado se o número possui algum divisor
					primo = false;
					i = num;
				}
			}

			return primo;
		}
	}

}
