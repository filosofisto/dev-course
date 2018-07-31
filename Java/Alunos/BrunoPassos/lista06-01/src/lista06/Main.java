package lista06;

import java.util.HashSet;

/*
 * 1.	Dado a classe Atleta que contém as seguintes informações: CPF, Nome, Modalidade e Número de Medalhas, 
 * como armazenar objetos deste tipo sem haver repetição de elementos?
 */
import java.util.Set;

public class Main {
	public static void main(String[] args) {

		Atleta atleta = new Atleta("Bruno Silva", "22233344455");
		Atleta atleta2 = new Atleta("Bruno Eduardo", "11122233344");
		Atleta atleta3 = new Atleta("João da Silva", "12312312312");
		Atleta atleta4 = new Atleta("Joao da Silva", "11122266677");

		Set<Atleta> set = new HashSet<>();
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
