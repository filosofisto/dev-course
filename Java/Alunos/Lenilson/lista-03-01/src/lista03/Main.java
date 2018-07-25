package lista03;

public class Main {

	public static void main(String[] args) {
		// Lista Crescente
		System.out.println("Lista crescente - 1 ate 50");
		for(int i = 1; i <=50; i++) {
			System.out.printf("\t%d\n", i);
		}
		
		//Lista Decrescente
		System.out.println("\nLista decrescente - 50 ate 1");
		for(int i = 50; i >= 1; i--) {
			System.out.printf("\t%d\n", i);
		}
	}

}
