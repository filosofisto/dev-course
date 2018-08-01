package control;

import model.Conta;
import model.FormatoA;
import model.FormatoB;
import model.FormatoSQL;

import static java.lang.System.out;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {

		Conta c = new Conta("Renan", "1245634535367890", "075756756798374257", "2434535353634345", 1000.50);
		out.println(c.toString());

		out.println("\n\t Formato A");
		FormatoA.serializarConta(c);
		c = FormatoA.deserializarConta();
		if (c != null) {
			out.println(c.toString());
		} else {
			out.println("null");
		}

		out.println("\n\t Formato B");
		FormatoB.serializarConta(c);
		c = FormatoB.deserializarConta();
		if (c != null) {
			out.println(c.toString());
		} else {
			out.println("null");
		}

		out.println("\n\t Formato SQL");
		FormatoSQL.serializarConta(c);
		ArrayList<Conta> contas = FormatoSQL.deserializarConta();
		for (Conta conta : contas) {
			out.println(conta.toString());
		}

	}

}
