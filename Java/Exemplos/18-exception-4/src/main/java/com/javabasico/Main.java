package com.javabasico;


public class Main {

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		p.setNome("Maradona");
		
		try {
			p.setIdade(1);
		} catch (IdadeNegativaException e) {
			System.err.println("Aviso: a data nao foi atualizada");
		} catch (IdadeMuitoGrandeException e) {
			System.err.println("Aviso: a data nao foi atualizada");
		} finally {
			System.err.println("Este bloco sera executado independente de erro");
		}
	}
}