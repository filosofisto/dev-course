package lista04;

public class Funcionario extends Pessoa {

	private int numeroMatricula;
	private double salarioBase;
	private int anosTrabalhados;
	
	public Funcionario(String nome, int idade, int numeroMatricula, double salarioBase, int anosTrabalhados) {
		super(nome, idade);
		setNumeroMatricula(numeroMatricula);
		setAnosTrabalhados(anosTrabalhados);
		setSalarioBase(salarioBase);
	}

	public int getAnosTrabalhados() {
		return anosTrabalhados;
	}

	public void setAnosTrabalhados(int anosTrabalhados) {
		this.anosTrabalhados = anosTrabalhados;
	}

	public int getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(int numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double calculaSalario() {

		/*double salario = 0;
		if (getAnosTrabalhados() > 0) {
			salario = (getSalarioBase() * getAnosTrabalhados()) / 100;
		}

		return this.salarioBase += salario;*/
		
		return getSalarioBase()*(1+getAnosTrabalhados()/100f);
	}

}
