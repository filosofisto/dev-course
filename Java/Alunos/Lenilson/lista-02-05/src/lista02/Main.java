package lista02;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		//Leitura do Console
		System.out.println("Informe a nota da prova 1: ");
		float n1 = ler.nextFloat();
		System.out.println("Informe a nota da prova 2: ");
		float n2 = ler.nextFloat();
		System.out.println("Informe a nota da prova 3: ");
		float n3 = ler.nextFloat();
		
		//Determinar a media aritmetica
		System.out.printf("\nMedia do aluno: %.2f", (n1 + n2 + n3) / 3);
	}

}
