package lista06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		Atleta atleta = new Atleta("Bruno Silva", "22233344455",2);
		Atleta atleta2 = new Atleta("Bruno Eduardo", "11122233344",5);
		Atleta atleta3 = new Atleta("João da Silva", "12312312312",8);
		Atleta atleta4 = new Atleta("Joao Ricardo", "11122266677",1);

		List<Atleta> atletas = new ArrayList<>();
		atletas.add(atleta);
		atletas.add(atleta2);
		atletas.add(atleta3);
		atletas.add(atleta4);
		
		Collections.sort(atletas/* new NumeroMedalhasComparator*/);
		

		for (Atleta a : atletas) {
			System.out.println(a.getNome());
		}
	}
}
