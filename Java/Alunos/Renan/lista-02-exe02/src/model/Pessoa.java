package model;

public class Pessoa {
	
	protected String nome;
	protected int idade;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public Pessoa(String nome, int idade) {
		this(nome);
		this.idade = idade;
	}
	

}
