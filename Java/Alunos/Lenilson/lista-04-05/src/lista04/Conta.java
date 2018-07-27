package lista04;

public class Conta {
	private int numero;
	private double saldo;
	
	public Conta(int numero) {
		setNumero(numero);
		saldo = 0;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void deposita (double valor) {
		this.saldo += valor;
		
	}
	
	public void retira (double valor) throws Exception{
		if (this.saldo < valor) {
			throw new Exception();
		}
		this.saldo -= valor;
	}
	
	public void transfere (double valor, Conta contaDestino) throws Exception{
		this.retira(valor);
		contaDestino.deposita(valor);
	}
	
	public void saldoAtual() {
		System.out.printf("Conta: %d Saldo Atual: R$ %.2f\n", numero, saldo);
	}
}
