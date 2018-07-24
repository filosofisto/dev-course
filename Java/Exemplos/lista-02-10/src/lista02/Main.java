package lista02;

import static java.lang.System.*;

public class Main {

	public static void main(String[] args) {
		if (args.length != 1 || args[0].equals("--help")) {
			usage();
		}
		
		int idade = Integer.parseInt(args[0]);
		
		if (idade < 5) {
			out.println("Nao existe categoria para esta idade");
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

	private static void usage() {
		System.out.println("------------------------------------------");
		System.out.println("Uso:");
		System.out.println("\tlista02-10 <idade>");
		System.out.println("\tOnde <idade> é a idade do nadador");
		System.out.println("------------------------------------------");
		System.exit(-1);
	}

}
