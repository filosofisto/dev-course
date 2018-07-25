package lista03;

public class Main {

	/*
	 * 8. Dado uma s�rie infinita (f�rmula abaixo), e calcule o valor da s�rie at�
	 * atingir a precis�o de 0,001. A precis�o � alcan�ada quando a diferen�a entre
	 * uma itera��o e outra � inferior a precis�o desejada. Exiba o resultado da
	 * soma e a quantidade de itera��es. Posteriormente aumenta a precis�o para
	 * 0,000001 e compare o resultado.
	 * 
	 * utilizar while (EDUARDO)
	 */

	public static void main(String[] args) {

		double x = 1;
		double xAnterior = 0;
		int denominador = 2;
		double precisao = 0.001;
		int count = 0;

		while ((x - xAnterior) > precisao) {
			xAnterior = x;
			x += 1d / denominador;
			denominador *= 2;
			count++;
		}

		System.out.printf("Valor: %.9f\n", x);
		System.out.printf("Calculos realizados: %d", count);
	}

}
