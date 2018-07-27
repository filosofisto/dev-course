package control;

import static java.lang.System.out;
import java.util.Random;

import model.Estatistica;


public class Teste {

	public static void main(String[] args) {
		
		double[] vetor = randomFillDouble();
		
		for(int i =0 ; i< vetor.length; i++) {
			out.println("\t["+i+"]\tValor:\t"+vetor[i]);
		}
		
		out.println("\n Estatística deste Vetor: \n");
		
		out.println("\tMédia Aritmética:\t"+Estatistica.mediaAritetica(vetor));
		out.println("\tMédia Ponderada:\t"+Estatistica.mediaPonderada(vetor, vetor));
		out.println("\tMediana:\t"+Estatistica.mediana(vetor));
		out.println("\tSoma:\t"+Estatistica.soma(vetor));
		
	}
	
	private static double[] randomFillDouble() {
		Random r =  new Random();
		
		double[] vetor = new double[r.nextInt(100)+1];
		
		for(int i = 0; i < vetor.length; i++) {
			vetor[i] = r.nextInt(vetor.length) * r.nextDouble();
		}
		
		return vetor;
	}

}
