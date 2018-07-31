package lista06;

import java.util.HashSet;
import java.util.LinkedHashSet;

/*
 * 2.	Altere o exercício anterior para que após adicionar diversos Atletas, imprima-os na ordem com que foram adicionados.
 */

public class Main {
	public static void main(String[] args) {

		Atleta atleta = new Atleta("Bruno Silva", "22233344455");
		Atleta atleta2 = new Atleta("Bruno Eduardo", "11122233344");
		Atleta atleta3 = new Atleta("João da Silva", "12312312312");
		Atleta atleta4 = new Atleta("Joao Ricardo", "11122266677");

		// Set<Atleta> set = new HashSet<>();
		// set.add(atleta);
		// set.add(atleta); // tenta inserir o mesmo objeto 1
		// set.add(atleta2);
		// set.add(atleta3);
		// set.add(atleta4);

		HashSet<Atleta> set = new LinkedHashSet<>();

		set.add(atleta);
		set.add(atleta); // tenta inserir o mesmo objeto 1
		set.add(atleta2);
		set.add(atleta3);
		set.add(atleta4);

		for (Atleta a : set) {
			System.out.println(a.toString());
		}
	}
}
