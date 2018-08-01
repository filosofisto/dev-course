package model;

public enum Modalidade {
	ARREMECOS_E_LANCAMENTOS("Arremeços e Lançamentos"), CORRIDA_COM_OBSTACULOS("Corrida com Obstáculos"),
	CORRIDA_DE_FUNDO("Corrida de Fundo"), CORRIDA_DE_MEIO_FUNDO("Corrida de Meio Fundo"),
	CORRIDA_DE_PISTA("Corrida de Pista"), MARATONA("Maratona"), REVEZAMENTO("Revezamento"), SALTOS_EM_ALTURA("Salto em Altura"),SALTOS_EM_DISTANCIA("Salto em Distância");

	String nome;

	Modalidade(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return nome;
	}
}
