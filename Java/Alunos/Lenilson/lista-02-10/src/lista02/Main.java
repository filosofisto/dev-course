package lista02;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.err.println("Digite a idade do nadador.");
			System.exit(-1);
		}
		
		int idade = Integer.parseInt(args[0]);
		
		if (idade < 5) {
			out.println("Nao existe categoria para esta idade.");
		} else if (idade <= 7) {
			out.println("Infantil A");	
		} else if (idade <= 10) {
			out.println("Infantil B");
		} else if (idade <= 13) {
			out.println("Juvenil A");
		} else if (idade <= 17) {
			out.println("Juvenil B");
		} else {
			out.println("Adulto");
		}
		
	}

}
