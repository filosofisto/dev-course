package model;

import java.sql.Timestamp;

public class Pessoa {

	private static int criadas = 0;
	private static int instancias = 0;

	protected String nome;
	protected Timestamp nascimento;
	protected long cpf;
	protected String rg;

	public Pessoa() {
		Pessoa.criadas++;
		Pessoa.instancias++;
	}

	public Pessoa(String nome, long cpf, String rg, Timestamp nascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.nascimento = nascimento;
		Pessoa.criadas++;
		Pessoa.instancias++;
	}

	public Pessoa(String nome) {
		this.nome = nome;
		Pessoa.criadas++;
		Pessoa.instancias++;
	}

	public Pessoa(String nome, long cpf) {
		this.nome = nome;
		this.cpf = cpf;
		Pessoa.criadas++;
		Pessoa.instancias++;
	}

	public Pessoa(String nome, String rg) {
		this.nome = nome;
		this.rg = rg;
		Pessoa.criadas++;
		Pessoa.instancias++;
	}

	public Pessoa(String nome, Timestamp nascimento) {
		this.nome = nome;
		this.nascimento = nascimento;
		Pessoa.criadas++;
		Pessoa.instancias++;
	}

	public static int getTotalDeInstanciasCriadas() {
		return Pessoa.criadas;
	}

	public static int getQuantidadeDeInstancias() {
		return Pessoa.instancias;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Timestamp getNascimento() {
		return nascimento;
	}

	public void setNascimento(Timestamp nascimento) {
		this.nascimento = nascimento;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	protected void finalize() {
		Pessoa.instancias--;
	}

}
