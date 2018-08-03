package com.cursojava;

public class Nadador {

	private String nome;
	private String cpf;
	private int idade;
	private String classificacaoNadador;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getClassificacaoNadador() {
		return classificacaoNadador;
	}

	public void setClassificacaoNadador(int idade) throws Exception {
		
		this.classificacaoNadador = verificaIdadeNadador(idade);

	}

	public String verificaIdadeNadador(int idade) throws Exception{

		if (idade <= 4)
			throw new RuntimeException("IDADE INVALIDA");
		if (idade >= 5 && idade <= 7)
			return "INFANTIL A";
		if (idade >= 8 && idade <= 10)
			return "INFANTIL B";
		if (idade >= 11 && idade <= 13)
			return "JUVENIL A";

		if (idade >= 14 && idade <= 17) {
			return "JUVENIL B";
		} else {
			return "ADULTO";
		}
	}

}
