package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Conta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1056998189693275103L;
	protected transient String dono;
	protected String cpf;
	protected String banco;
	protected String agencia;
	protected double saldo;

	public Conta() {
	}

	public Conta(String dono, String cpf, String banco, String agencia, double saldo) {
		this.dono = dono;
		this.cpf = cpf;
		this.banco = banco;
		this.agencia = agencia;
		this.saldo = saldo;
	}

	public Conta(String cpf, String banco, String agencia, double saldo) {
		this.cpf = cpf;
		this.banco = banco;
		this.agencia = agencia;
		this.saldo = saldo;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeObject(this.cpf);
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		this.cpf = (String) in.readObject();
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

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

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Conta [cpf=" + cpf + ", banco=" + banco + ", agencia=" + agencia + ", saldo=" + saldo + "]";
	}

}
