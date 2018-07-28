package lista04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Teste dos Pontos\n");
		
		//Cria��o do Ponto A - Entrada Manual
		Ponto a = new Ponto();
		
		System.out.println("Digite a coordenada X do ponto A: ");
		a.setX(ler.nextInt());
		
		System.out.println("Digite a coordenada Y do ponto A: ");
		a.setY(ler.nextInt());
		
		//Cria��o do Ponto B
		Ponto b = new Ponto (4,5);
		System.out.println("Cria��o do Ponto B: " + b.toString());
		
		//Distancia entre A e B
		System.out.printf("\nDistancia entre o ponto A%s e B%s: %.2f\n\n", a.toString(), b.toString(), b.distancia(a));
		
		//Clonando o Ponto B
		Ponto c = b.getClone();
		
		//Verificando as igualdades
		
		//Entre A e B
		if (a.equals(b)) {
			System.out.println("Pontos A e B s�o iguais!");
		} else {
			System.out.println("Pontos A e B n�o s�o iguais!");
		}
		
		//Entre B e C
		if (b.equals(c)) {
			System.out.println("Pontos B e C s�o iguais!");
		} else {
			System.out.println("Pontos B e C n�o s�o iguais!");
		}
		
		
		//Cria��o dos Pontos 3D
		Ponto3D a3D = new Ponto3D(1, 0, 0);
		Ponto3D b3D = new Ponto3D(10, 0, 0);
		System.out.println("Cria��o do Ponto A3D: " + a3D.toString());
		System.out.println("Cria��o do Ponto B3D: " + b3D.toString());
		
		//Distancia entre A3D e B3D
		System.out.printf("\nDistancia entre o ponto A3D%s e B3D%s: %.2f\n\n", a3D.toString(), b3D.toString(), b3D.distancia(a3D));
		
		//Clonando o Ponto B3D
		Ponto c3D = b3D.getClone();
		
		//Verificando as igualdades
		
		//Entre A3D e B3D
		if (a3D.equals(b3D)) {
			System.out.println("Pontos A3D e B3D s�o iguais!");
		} else {
			System.out.println("Pontos A3D e B3D n�o s�o iguais!");
		}
		
		//Entre B3D e C3D
		if (b3D.equals(c3D)) {
			System.out.println("Pontos B3D e C3D s�o iguais!");
		} else {
			System.out.println("Pontos B3D e C3D n�o s�o iguais!");
		}
		
		
		
		//Cria��o dos Pontos Coloridos
		PontoColorido aVermelho = new PontoColorido(5,0,"vermelho");
		System.out.println("Cria��o do Ponto A Vermelho: " + aVermelho.toString());
		
		
	}

}
