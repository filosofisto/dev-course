package lista03;

public class Main {

	// 2. Construa um programa que imprime apenas os números pares entre 1 a 50.
	public static void main(String[] args) {

		for (int i = 1; i <= 50; i++) {

			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

}
