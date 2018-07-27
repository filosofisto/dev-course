package lista04;

public class Gerente extends Funcionario {

	private final double adicionalCargo = 2500;

	public Gerente(String nome, int idade, int numeroMatricula, double salarioBase, int anosTrabalhados) {
		super(nome, idade, numeroMatricula, salarioBase, anosTrabalhados);
	}

	public double getAdicionalCargo() {
		return adicionalCargo;
	}

	@Override
	public double calculaSalario() {
		return super.calculaSalario() + this.adicionalCargo;
	}

}
