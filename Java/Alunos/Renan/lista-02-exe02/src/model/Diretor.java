package model;

public class Diretor extends Funcionario {

	@Override
	public double calcularSalario() {
		return super.calcularSalario() + (2500 + 3500);
	}
}
