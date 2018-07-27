package com.javabasico;


public class Main {

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		p.setNome("Maradona");
		
		try {
			p.setIdade(Integer.parseInt(args[0]));
		} catch (Exception e) {
			System.out.println("Sr usuario lamendo mas a idade nao eh valida");
			System.exit(-1);
			//e.printStackTrace();
		}
		
		System.out.println("Pessoa criada com sucesso");
	}
}
