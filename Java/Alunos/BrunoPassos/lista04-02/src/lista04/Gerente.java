package lista04;

public class Gerente extends Funcionario {

	private final static double ADICIOANAL_CARGO = 2500;

	public Gerente(String nome, int idade, int numeroMatricula, double salarioBase, int anosTrabalhados) {
		super(nome, idade, numeroMatricula, salarioBase, anosTrabalhados);
	}

	@Override
	public double calculaSalario() {
		return super.calculaSalario() + ADICIOANAL_CARGO;
	}

}
