package lista02;

public class Main {
	/*
	 * 10. Elabore um programa que dada a idade de um nadador, que será informada
	 * através de parâmetro passado ao programa, classifica-o em uma das seguintes
	 * categorias: 
	 * I. Infantil A = 5-7 anos 
	 * II. Infantil B = 8-10 anos 
	 * III. JuvenilA = 11-13 anos 
	 * IV. Juvenil B = 14-17 anos 
	 * V. Adulto = maiores de 18 anos
	 * 
	 */

	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("É necessario apenas 1 parametro !");
			System.exit(-1);
		}
		
		int idade = Integer.parseInt(args[0]);
		
		if(idade < 5) {
			System.out.println("Nao existe categoria");
		}
		else if(idade <=7) {
			System.out.println("infantil A");
			//infantil A
		}else if(idade <= 10) {
			System.out.println("infantil B");
			//infantil B
		}else if(idade <= 13) {
			System.out.println("juvenilA");
			// juvenilA
		}else if(idade <=17) {
			System.out.println("juvenilB");
			// juvenilB
		}else {
			System.out.println("Maior de 18 anos");
		}
	}

}
