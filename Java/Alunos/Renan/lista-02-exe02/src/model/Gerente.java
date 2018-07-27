package model;

public class Gerente extends Funcionario {

	public Gerente() {
	}
	
	public Gerente(String nome, int idade, int matricula, double salario_base, int anos_trabalhados) {
		super(nome, idade, matricula, salario_base, anos_trabalhados);
	}

	@Override
	public double calcularSalario() {
		return super.calcularSalario() + 2500;
	}
	
	

}
