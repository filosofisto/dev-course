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
		return "Operacao [saldoAtual=" + saldoAtual + ", saldoAnterior=" + saldoAnterior + ", tipoOp=" + tipoOp + "]";
	}
	
	
	
}
