package lista02;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rnd = new Random();
		int n1 = rnd.nextInt(10)+1;
		int n2 = rnd.nextInt(10)+1;
		int n3 = rnd.nextInt(10)+1;
		
		float media = (n1+n2+n3)/3f;
		
		if (media >= 6f) {
			System.out.printf("Aprovado, media: %.2f", media);
		} else {
			System.out.printf("Reprovado, media: %.2f", media);
		}
	}

}
