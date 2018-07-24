package lista02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		//Leitura das Notas
		System.out.print("Informe a nota 1: ");
		float n1 = ler.nextFloat();
		System.out.print("Informe a nota 2: ");
		float n2 = ler.nextFloat();
		System.out.print("Informe a nota 3: ");
		float n3 = ler.nextFloat();
		
		//Leitura da opcao do calculo da media
		System.out.println("Escolha a media desejada: ");
		System.out.print("Opcoes: (1) Aritmetica    (2) Ponderada [p1=3, p2=3 e p3=4]    (3) Harmonica : ");
		int opcao = ler.nextInt();
		
		//Calculo da media
		switch (opcao) {
		case 1:
			System.out.printf("\nMedia aritmetica: %.2f\n", (n1 + n2 + n3) / 3);
			break;
		case 2:
			System.out.printf("\nMedia ponderada: %.2f\n", (n1*3 + n2*3 + n3*4) / 10);
			break;
		case 3:
			System.out.printf("\nMedia harmonica: %.2f\n", 3 / (1 / n1 + 1 / n2 + 1 / n3));
			break;
		default:
			System.out.println("Opcao invalida.");
			break;
		}
	}

}
