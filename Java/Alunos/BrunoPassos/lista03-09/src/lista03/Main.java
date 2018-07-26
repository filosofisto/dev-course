package lista03;

public class Main {

	/*
	 * 9. Calcule o famoso n�mero PI atrav�s da s�rie infinita descoberta pelo
	 * grande matem�tico Leibniz. Calcule com precis�o 0,01 e depois aumente a
	 * precis�o para 0,0001. (EDUARDO)
	 */

	static final double PRECISAO = 0.0000001;

	public static void main(String[] args) {
		
		double quartoDePi = 0;
		double quartoDePiAnterior = -1;
		int denominador = 1;
		int sinal = 1;

		while (Math.abs(quartoDePi - quartoDePiAnterior) > PRECISAO) {
			quartoDePiAnterior = quartoDePi;

			quartoDePi += sinal * 1d / denominador;

			denominador += 2;
			sinal = -sinal;
		}

		double pi = 4 * quartoDePi;
		System.out.printf("Pi = %.10f", pi);
	}

}
