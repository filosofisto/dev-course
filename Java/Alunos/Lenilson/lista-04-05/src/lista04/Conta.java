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

	public void deposita (double valor, TipoOperacao tipoOp) {
		double saldoFinal = saldo + valor;
		Operacao operacao;
		
		if(tipoOp == TipoOperacao.TRANSFERE) {
			operacao = new Operacao(TipoOperacao.TRANSFERE, saldo, saldoFinal);
			//System.out.print(operacao + "\n");
		} else {
			operacao = new Operacao(TipoOperacao.DEPOSITA, saldo, saldoFinal);
			System.out.printf("CONTA: %d - %s\n", this.getNumero(), operacao);
		}
		
		this.saldo = saldoFinal;
		adicionarOperacao(operacao);
		//System.out.print(operacao + "\n");
		
	}
	
	public void deposita (double valor) {
		this.deposita(valor, TipoOperacao.DEPOSITA);
	}

	public void retira (double valor, TipoOperacao tipoOp) throws Exception {
		if (this.saldo < valor) {
			throw new Exception("Saldo insuficiente!\n");
		}
		
		double saldoFinal = saldo - valor;
		Operacao operacao;
		
		if(tipoOp == TipoOperacao.TRANSFERE) {
			operacao = new Operacao(TipoOperacao.TRANSFERE, saldo, saldoFinal);
			//System.out.print(operacao + "\n");
		} else {
			operacao = new Operacao(TipoOperacao.RETIRA, saldo, saldoFinal);
			//System.out.printf("CONTA: %d - SAQUE -", this.getNumero());
		}
		
		this.saldo = saldoFinal;
		adicionarOperacao(operacao);
		System.out.printf("CONTA: %d - %s\n", this.getNumero(), operacao);
	}
	
	public void retira (double valor) throws Exception {
		if (this.saldo < valor) {
			throw new Exception("Saldo insuficiente!\n");
		}
		
		this.retira(valor, TipoOperacao.RETIRA);
	}
	
	public void transfere (double valor, Conta contaDestino) throws Exception {
		if (this.saldo < valor) {
			throw new Exception("Saldo insuficiente!\n");
		}
		//System.out.printf("CONTA: %d - TRANSFERÊNCIA PARA CONTA %d - ", this.getNumero(), contaDestino.getNumero());
		this.retira(valor, TipoOperacao.TRANSFERE);
		contaDestino.deposita(valor, TipoOperacao.TRANSFERE);
		
	}
	
	private void adicionarOperacao(Operacao operacao) {
		if(index < 9) {
			operacoes[++index] = operacao;
		} else {
			//Mantem as ultimas 10 operações realizadas na conta
			RotateOperacao extrato = new RotateOperacao(operacoes);
			try {
				extrato.girarExtrato();
				operacoes[index] = operacao;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void saldoAtual() {
		System.out.printf("Conta: %d Saldo Atual: R$ %.2f\n", numero, saldo);
	}
	
	public void extrato() {
		System.out.printf("\n*************************************");
		System.out.printf("\n\tExtrato da Conta: %d\n", numero);
		for (Operacao op: operacoes) {
			if(op != null) {
				System.out.println(op);
			}
		}
		System.out.printf("*************************************\n\n");
	}
}
