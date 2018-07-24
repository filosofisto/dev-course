package lista02;

import java.util.Scanner;

public class Main {

	/*
	 * 7. O custo ao consumidor de um carro novo é a soma do custo de fábrica
	 * somados a percentagem do distribuidor e dos impostos (aplicados ao custo de
	 * fábrica). Supondo que a percentagem do distribuidor seja de 1,8% e os
	 * impostos de 45%, escrever um programa que leia do console o custo de fábrica
	 * de um carro e imprima o custo final.
	 */

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Informe o custo de fabrica do carro: ");
		float custodeFabrica = scan.nextFloat();
		
		float percentualDistribuidor = (custodeFabrica * 0.018f);
		float percentualImpostos = (custodeFabrica * 0.45f);
		
		float custoFinal = custodeFabrica + percentualDistribuidor + percentualImpostos;

		System.out.println("O custo final do carro é: " + custoFinal);
	}

}
