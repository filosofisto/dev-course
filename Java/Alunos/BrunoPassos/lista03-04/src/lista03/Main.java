package lista03;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Random random = new Random();

		int fat = 1;
		int valor = random.nextInt(20) + 1;
		for (int i = 2; i <= valor; i++) {
			fat *= i;
		}

		System.out.println("O fatorial de " + valor + " é igual a " + fat);
	}

}
