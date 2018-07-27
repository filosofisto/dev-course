package lista04;

public class Diretor extends Gerente {
	
	private final static double AUXILIO_MORADIA = 3500;

	public Diretor(String nome, int idade, int numeroMatricula, double salarioBase, int anosTrabalhados) {
		super(nome, idade, numeroMatricula, salarioBase, anosTrabalhados);
	}

	@Override
	public double calculaSalario() {
		return super.calculaSalario() + AUXILIO_MORADIA;
	}
}
