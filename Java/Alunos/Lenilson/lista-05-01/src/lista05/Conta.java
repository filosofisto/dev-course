package lista05;

import java.io.Serializable;

public class Conta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1065937666009744958L;
	private String banco;
	private String agencia;
	private String cpf;
	private double saldo;
	
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "Conta [banco=" + banco + ", agencia=" + agencia + ", cpf=" + cpf + ", saldo=" + saldo + "]";
	}
	
	

	

}
