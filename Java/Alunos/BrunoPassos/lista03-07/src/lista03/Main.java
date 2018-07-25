package lista03;

public class Main {
	/*
	 * 7. Escreva um programa que calcule o valor de H, sendo que ele é determinado
	 * pela série H = 1/1 + 3/2 + 5/3 + 7/4 + ... + 99/50.
	 */
	public static void main(String[] args) {

		int vetorA[] = new int[100];
		int vetorB[] = new int[100];

		int denominador = 1;
		int divisor = 1;
		double h = 0;
		for (int i = 0; i < 100; i++) {
			vetorA[i] = denominador;
			vetorB[i] = divisor;
			h += vetorA[i] / vetorB[i];
			divisor++;
			denominador += 2;
		}
		System.out.println("Valor de H: " + h);
		

	}

}
