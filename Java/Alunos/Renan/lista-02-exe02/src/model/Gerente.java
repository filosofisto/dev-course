package model;

public class Gerente extends Funcionario {

	public Gerente() {
	}

	@Override
	public double calcularSalario() {
		return super.calcularSalario() + 2500;
	}

}
