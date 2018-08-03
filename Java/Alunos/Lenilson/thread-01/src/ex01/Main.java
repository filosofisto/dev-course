package ex01;


/**
 * Exemplo demonstrando utilizacao de threads paralelas.
 * 
 * @author eduardo
 *
 */
public class Main {

	public static void main(String[] args) {
		Corredor[] corredor = new Corredor[8];
		//Constroi as threads - Corredores
		for (int i = 0; i < corredor.length; i++) {
			corredor[i] = new Corredor(i);
		}
		
		//Inicia as threads
		for (int i = 0; i < corredor.length; i++) {
			corredor[i].start();
		}
		
	}
}
