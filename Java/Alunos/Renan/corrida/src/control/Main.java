package control;

import java.util.Arrays;
import java.util.Random;

import model.Corredor;
import static java.lang.System.out;

public class Main {

	private static Corredor[] corredores;
	private static int chegada;

	public static void main(String[] args) throws InterruptedException {

		Random r = new Random();
		chegada = r.nextInt(100) + 25;

		System.out.println("\n\t Que comece a corrida de " + chegada + " unidades!");
		corredores = instaciarCorredor(r.nextInt(10) + 3, chegada, true);

		

		while(!isCorridaFinalizada(corredores)) {
			Thread.sleep(100);
		}
		
		out.println("\n\t Fim da Corrida!");
		Arrays.sort(corredores);
		
		out.println("\n\t Ordem de chegada: ");
		for (Corredor c : corredores) {
			out.println(c.toString());
		}
		
		out.println("\n\t Vencedores: ");
		out.println("\t	1º Lugar:\t"+corredores[0].toString());
		out.println("\t	2º Lugar:\t"+corredores[1].toString());
		out.println("\t	3º Lugar:\t"+corredores[2].toString());
		out.println("\t	Último Lugar:\t"+corredores[corredores.length-1].toString());
	}

	private static Corredor[] instaciarCorredor(int quantidade, int chegada, boolean teraoSono) {
		Corredor[] corredores = new Corredor[quantidade];

		for (int i = 0; i < corredores.length; i++) {
			corredores[i] = new Corredor(chegada, teraoSono);
			corredores[i].start();
		}
		return corredores;
	}

	private static boolean isCorridaFinalizada(Corredor... corredores) {
		boolean terminou = true;

		for (Corredor c : corredores) {
			if (!c.chegou()) {
				terminou = false;
				break;
			}
		}

		return terminou;
	}

}
