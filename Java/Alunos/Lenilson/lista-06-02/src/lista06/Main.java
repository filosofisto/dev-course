package lista06;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Set<Atleta> atletas = new LinkedHashSet<>();
		atletas.add(new Atleta("123.321.456-10", "Bruno", "Atletismo", 3));
		atletas.add(new Atleta("987.789.654-20", "Renan", "Natação", 5));
		atletas.add(new Atleta("987.789.654-20", "Eduardo", "Bocha", 0));
		atletas.add(new Atleta("333.111.222-56", "Lenilson", "Tenis de Mesa", 2));
		
		
		for (Atleta atleta : atletas) {
			System.out.println(atleta);
		}
		
	}

}
