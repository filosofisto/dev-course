package lista04;

public class Diretor extends Gerente {
	
	private final double auxilioMoradia = 3500;

	public Diretor(String nome, int idade, int numeroMatricula, double salarioBase, int anosTrabalhados) {
		super(nome, idade, numeroMatricula, salarioBase, anosTrabalhados);
	}

	public double getAuxilioMoradia() {
		return auxilioMoradia;
	}
	
	@Override
	public double calculaSalario() {
		return super.calculaSalario() + this.auxilioMoradia;
	}

	
	


}
