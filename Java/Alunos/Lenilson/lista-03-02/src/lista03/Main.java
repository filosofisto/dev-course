package lista03;

public class Main {

	public static void main(String[] args) {
		// Numeros Pares entre 1 e 50
		System.out.println("Numeros pares entre 1 e 50");
		for(int i = 1; i <=50; i++) {
			if(i % 2 == 0) {
				System.out.printf("\t%d\n", i);
			}			
		}
	}

}
