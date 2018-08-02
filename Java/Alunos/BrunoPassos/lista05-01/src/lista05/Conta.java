package lista05;

import java.io.Serializable;

public class Conta implements Serializable {

	private static final long serialVersionUID = 1117871575536821659L;

	private String numeroDoBanco;
	private String numeroDaAgencia;
	private String cpf;
	private double saldoConta;

	public String getNumeroDoBanco() {
		return numeroDoBanco;
	}

	public void setNumeroDoBanco(String numeroDoBanco) {
		this.numeroDoBanco = numeroDoBanco;
	}

	public String getNumeroDaAgencia() {
		return numeroDaAgencia;
	}

	public void setNumeroDaAgencia(String numeroDaAgencia) {
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
