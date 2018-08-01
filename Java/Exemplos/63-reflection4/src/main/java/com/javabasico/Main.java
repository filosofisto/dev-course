package com.javabasico;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		
		p.setIdade(66);
		p.setNome("Maradona");
		
		Pessoa airton = new Pessoa();
		
		airton.setIdade(40);
		airton.setNome("Senna");
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(p);
		pessoas.add(airton);
		
		ExportadorXML exportadorXML = 
				new ExportadorXML();
		
		try {
			String xml = exportadorXML
					.cabecalho()
					.exportar(pessoas, "pessoas");
			System.out.println(xml);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
			e.printStackTrace();
		}

		List<Veiculo> veiculos = new ArrayList<>();

		veiculos.add(new Veiculo("AAA9876", "Fiat", "423432423"));
		veiculos.add(new Veiculo("AAA3847", "Ford", "3842397432"));
		veiculos.add(new Veiculo("AAA5285", "Ferrari", "582396324"));
		veiculos.add(new Veiculo("AAA1111", "Hunday", "32376648792"));
		veiculos.add(new Veiculo("AAA2456", "Porche", "3773749506"));
		veiculos.add(new Veiculo("AAA0373", "Dodge", "459755757"));

		try {
			String xml = exportadorXML
					.cabecalho()
					.exportar(veiculos, "veiculos");
			System.out.println(xml);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
