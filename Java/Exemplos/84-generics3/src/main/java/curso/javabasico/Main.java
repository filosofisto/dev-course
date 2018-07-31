package curso.javabasico;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import curso.javabasico.tiger.ListaEncadeada;
import curso.javabasico.tiger.Pessoa;

public class Main {

	public static void main(String[] args) {
		ListaEncadeada<Pessoa> listPessoas = 
			new ListaEncadeada<>();
		
		Pessoa p1 = new Pessoa("Fulano");
		Pessoa p2 = new Pessoa("Ciclano");
		String x = "asdadasd";
		
		listPessoas.add(p1);
		listPessoas.add(p2);
		
		System.out.println("Pessoas: " + listPessoas);
		
		ListaEncadeada<Integer> listIntegers = 
				new ListaEncadeada<>();
		
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(2);
		
		listIntegers.add(i1);
		listIntegers.add(i2);
		
		System.out.println("Integers: " + listIntegers);
		
		System.out.printf("Media: %.2f\n", media(10d, 8f, new BigDecimal(9)));
	}
	
	static <T extends Number> T media(T... elementos) {
		double soma = 0;
		
		for (T item: elementos) {
			soma += item.doubleValue();
		}
		
		if (elementos.length > 0) {
			return (T) new Double(soma/elementos.length);
		} else {
			return (T) new Double(0);
		}
	}
}
