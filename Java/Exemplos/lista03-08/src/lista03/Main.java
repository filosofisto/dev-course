package lista03;

public class Main {

	public static void main(String[] args) {
		double x = 1;
		double xAnterior = 0;
		int denominador = 2;
		double precisao = 0.001;
		int count = 0;
		
		while ((x-xAnterior) > precisao) {
			xAnterior = x;
			x += 1d/denominador;
			denominador *= 2;
			count++;
		}
		
		System.out.printf("Valor: %.9f\n", x);
		System.out.printf("Calculos realizados: %d", count);
	}

}
