package lista04;

public class Conta {
	
	private int numero;
	private double saldo;
	private Operacao[] operacoes;
	private int index;
	
	public Conta(int numero) {
		setNumero(numero);
		saldo = 0;
		operacoes = new Operacao[10];
		index = -1;
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
		double saldoFinal = saldo + valor;
		Operacao operacao = new Operacao(TipoOperacao.DEPOSITA, saldo, saldoFinal);
		
		this.saldo = saldoFinal;
		adicionarOperacao(operacao);
	}

	private void adicionarOperacao(Operacao operacao) {
		operacoes[++index] = operacao;
	}
	
	public void retira (double valor) throws Exception {
		if (this.saldo < valor) {
			throw new Exception("Saldo insuficiente");
		}
		
		double saldoFinal = saldo - valor;
		Operacao operacao = new Operacao(TipoOperacao.RETIRA, saldo, saldoFinal);
		this.saldo = saldoFinal;
		adicionarOperacao(operacao);
	}
	
	public void transfere (double valor, Conta contaDestino) throws Exception {
		this.retira(valor);
		contaDestino.deposita(valor);
	}
	
	public void saldoAtual() {
		System.out.printf("Conta: %d Saldo Atual: R$ %.2f\n", numero, saldo);
	}
	
	public void extrato() {
		for (Operacao op: operacoes) {
			System.out.println(op);
		}
	}
}
