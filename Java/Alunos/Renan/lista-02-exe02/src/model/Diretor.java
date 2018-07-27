package model;

public class Diretor extends Funcionario {

	public Diretor() {
		
	}
	
	public Diretor(String nome, int idade, int matricula, double salario_base, int anos_trabalhados) {
		super(nome, idade, matricula, salario_base, anos_trabalhados);
	}
	
	@Override
	public double calcularSalario() {
		return super.calcularSalario() + (2500 + 3500);
	}
}
