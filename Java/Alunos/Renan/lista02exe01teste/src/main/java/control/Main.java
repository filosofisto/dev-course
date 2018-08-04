package control;

import java.util.Scanner;

import model.Nadador;

public class Main {

	public static void main(String[] args) {
		Nadador n = null;

		try {
			n = new Nadador(args[0], Integer.parseInt(args[1]));
		} catch (Exception e) {
			System.out.println("\n\t Insira o nome e idade do nadador");
			Scanner in = new Scanner(System.in);
			n = new Nadador(in.nextLine(), in.nextInt());
		} finally {
			System.out.println(n.toString());
		}

	}

}
