package poo;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Pessoa[] pessoas = new Pessoa[4];
		
		pessoas[0] = new Pessoa("Renan",    "245.678.987-03");
		pessoas[1] = new Pessoa("Bruno",    "245.555.666-00");
		pessoas[2] = new Pessoa("Lenilson", "133.567.890-22");
		pessoas[3] = new Pessoa("Eduardo",  "133.567.799-34");
		
 
		Ordenator.sort(pessoas);
		//Arrays.sort(pessoas, new CPFComparator());
		
		for (Pessoa p: pessoas) {
			System.out.println(p.getNome()); 
		}
		
		System.out.println();
		
		Automovel[] automoveis = new Automovel[4];
		
		automoveis[0] = new Automovel("ZZZ-4566");
		automoveis[1] = new Automovel("CCC-4566");
		automoveis[2] = new Automovel("DDD-4566");
		automoveis[3] = new Automovel("AAA-4566");
		
		Ordenator.sort(automoveis);
		
		for (Automovel a: automoveis) {
			System.out.println(a.getPlaca()); 
		}
		
		System.out.println();
		
		Ordenator.sort(automoveis, new PlacaInvertidaComparator());
		
		for (Automovel a: automoveis) {
			System.out.println(a.getPlaca()); 
		}
	}

}
