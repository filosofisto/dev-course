package control;

import static java.lang.System.out;
import java.util.Random;

import model.Estatistica;


public class Teste {

	public static void main(String[] args) {
		
		System.out.println(Estatistica.mediaAritetica(new double[] {}));
		
		double[] vetor = randomFillDouble();
		
		for(int i =0 ; i< vetor.length; i++) {
			out.println("\t["+i+"]\tValor:\t"+vetor[i]);
		}
		
		out.println("\n Estat�stica deste Vetor: \n");
		
		out.println("\tM�dia Aritm�tica:\t"+Estatistica.mediaAritetica(vetor));
		out.println("\tM�dia Ponderada:\t"+Estatistica.mediaPonderada(vetor, vetor));
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
