package control;

import java.util.Random;

import model.Corredor;
import static java.lang.System.out;

public class Main {

	private static Corredor[] corredores;
	private static int chegada;

	public static void main(String[] args) {

		Random r = new Random();
		chegada = r.nextInt(100) + 25;

		System.out.println("\n\t Que comece a corrida de " + chegada + " unidades!");
		corredores = instaciarCorredor(r.nextInt(10) + 3, chegada, true);
		
		
	}

	private static Corredor[] instaciarCorredor(int quantidade, int chegada, boolean teraoSono) {
		Corredor[] corredores = new Corredor[quantidade];

		for (int i = 0; i < corredores.length; i++) {
			corredores[i] = new Corredor(chegada, teraoSono);
			corredores[i].start();
		}
		return corredores;
	}
	
	

}
