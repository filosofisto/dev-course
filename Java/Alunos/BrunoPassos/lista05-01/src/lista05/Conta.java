package lista05;

public class Conta {

	private int numeroDoBanco;
	private int numeroDaAgencia;
	private String cpf;
	private double saldoConta;

	public int getNumeroDoBanco() {
		return numeroDoBanco;
	}

	public void setNumeroDoBanco(int numeroDoBanco) {
		this.numeroDoBanco = numeroDoBanco;
	}

	public int getNumeroDaAgencia() {
		return numeroDaAgencia;
	}

	public void setNumeroDaAgencia(int numeroDaAgencia) {
		this.numeroDaAgencia = numeroDaAgencia;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(double saldoConta) {
		this.saldoConta = saldoConta;
	}

}
