package model;

import java.math.BigDecimal;

public class Funcionario extends Pessoa {

	protected int matricula;
	protected double salario_base;
	protected double anos_trabalhados;

	public Funcionario() {
	}

	public Funcionario(String nome) {
		super(nome);
	}

	public Funcionario(String nome, int idade, int matricula, double salario_base) {
		super(nome, idade);
		this.matricula = matricula;
		this.salario_base = salario_base;
	}

	public Funcionario(String nome, int idade, int matricula, double salario_base, int anos_trabalhados) {
		this(nome, idade, matricula, salario_base);
		this.anos_trabalhados = anos_trabalhados;
	}

	public double calcularSalario() {
		return this.salario_base * (1 + 0.01 * this.anos_trabalhados);
	}

}
