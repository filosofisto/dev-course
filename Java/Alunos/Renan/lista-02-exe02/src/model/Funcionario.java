package model;

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

	public String toString() {
		return super.toString() + "\n Número de Matricula:\t" + this.matricula + "\n Salário Base:\t"
				+ this.salario_base + "\n Anos Trabalhados:\t" + this.anos_trabalhados;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public double getSalario_base() {
		return salario_base;
	}

	public void setSalario_base(double salario_base) {
		this.salario_base = salario_base;
	}

	public double getAnos_trabalhados() {
		return anos_trabalhados;
	}

	public void setAnos_trabalhados(double anos_trabalhados) {
		this.anos_trabalhados = anos_trabalhados;
	}

	
	
}
