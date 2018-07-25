package lista03;

public class Main {
	/*
	 * 7. Escreva um programa que calcule o valor de H, sendo que ele � determinado
	 * pela s�rie H = 1/1 + 3/2 + 5/3 + 7/4 + ... + 99/50.
	 */
	public static void main(String[] args) {
		int numerador = 1;
		int denominador = 1;
		double h = 0;
		
		while (denominador < 50 && numerador < 99) {
			h += numerador/denominador;
			numerador += 2;
			denominador++;
		}

		System.out.println("Valor de H: " + h);
	}
}
