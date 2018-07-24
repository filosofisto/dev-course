package lista02;

import java.io.Console;
import java.util.Scanner;

public class Main {
	// 4. Construa um programa que leia a partir do console a idade de uma pessoa
	// expressa em anos, meses e
	// dias e imprima no console a idade expressa apenas em dias.

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Digite a sua idade em anos: ");
		int idadeAnos = scan.nextInt();
		System.out.println("Digite os meses: ");
		int idadeMeses = scan.nextInt();
		System.out.println("Digite os dias: ");
		int idadeDias = scan.nextInt();
		
		// converte anos para dias
		int anos = idadeAnos * 365;
		
		// converter meses para dias ( considerando mes de 30 dias)
		int meses = idadeMeses * 30;
		
		int calculoDiasIdade = (anos + meses + idadeDias);
		
		System.out.println("Conversao anos para dias: " + anos); 
		System.out.println("Conversao meses para dias: " + meses); 
		
		System.out.println("Resultado da idade em dias: " + calculoDiasIdade + "DIAS");
		

	}

}
