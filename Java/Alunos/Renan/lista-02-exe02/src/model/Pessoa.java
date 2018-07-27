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
	
	public String toString() {
		return "\n Nome:\t"+this.nome + "\n Idade:\t"+this.idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	

}
