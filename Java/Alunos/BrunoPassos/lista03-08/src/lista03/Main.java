package lista03;

public class Main {

	/*
	 * 8. Dado uma série infinita (fórmula abaixo), e calcule o valor da série até
	 * atingir a precisão de 0,001. A precisão é alcançada quando a diferença entre
	 * uma iteração e outra é inferior a precisão desejada. Exiba o resultado da
	 * soma e a quantidade de iterações. Posteriormente aumenta a precisão para
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
