package lista04;

public class Operacao {
	private double saldoAtual;
	private double saldoAnterior;
	private TipoOperacao tipoOp;
	
	public Operacao(TipoOperacao tipoOp, double saldoAnterior, double saldoAtual) {
		setTipoOp(tipoOp);
		setSaldoAnterior(saldoAnterior);
		setSaldoAtual(saldoAtual);
	}
	
	public Operacao() {
		
	}

	public double getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public double getSaldoAnterior() {
		return saldoAnterior;
	}

	public void setSaldoAnterior(double saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}

	public TipoOperacao getTipoOp() {
		return tipoOp;
	}

	public void setTipoOp(TipoOperacao tipoOp) {
		this.tipoOp = tipoOp;
	}

	@Override
	public String toString() {
		switch (this.tipoOp) {
		case DEPOSITA:
			return "DEPÓSITO - VALOR: R$ " + (saldoAtual - saldoAnterior) + "	SALDO ATUAL: R$ " + saldoAtual; 
		case RETIRA:
			return "SAQUE - VALOR: R$ " + (saldoAnterior - saldoAtual) + "	SALDO ATUAL: R$ " + saldoAtual;
		case TRANSFERE:
			if(saldoAtual < saldoAnterior) {
				return "TRANSFERÊNCIA - VALOR: R$ " + (saldoAnterior - saldoAtual) + "	SALDO ATUAL: R$ " + saldoAtual;
			}
			return "TRANSFERÊNCIA - VALOR: R$ " + (saldoAtual - saldoAnterior) + "	SALDO ATUAL: R$ " + saldoAtual;
		default:
			return "";
		}
	}
	
	
	
}
